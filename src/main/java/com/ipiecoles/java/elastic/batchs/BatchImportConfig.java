package com.ipiecoles.java.elastic.batchs;

import com.ipiecoles.java.elastic.batchs.activite.DeputeActiviteItemProcessor;
import com.ipiecoles.java.elastic.batchs.activite.DeputeActiviteItemWriter;
import com.ipiecoles.java.elastic.batchs.general.DeputeItemProcessor;
import com.ipiecoles.java.elastic.batchs.general.DeputeItemWriter;
import com.ipiecoles.java.elastic.batchs.general.DisableDeputeTasklet;
import com.ipiecoles.java.elastic.batchs.model.DeputeActivite;
import com.ipiecoles.java.elastic.batchs.model.DeputeActiviteRoot;
import com.ipiecoles.java.elastic.batchs.model.DeputeDataRoot;
import com.ipiecoles.java.elastic.batchs.model.DeputeData;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.util.Map;

@Configuration
@EnableBatchProcessing
public class BatchImportConfig {

    public static final String FILENAME = "filename";

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    @StepScope
    public JsonItemReader<DeputeDataRoot> jsonItemReader(@Value("#{jobParameters}") Map jobParameters) {
        return new JsonItemReaderBuilder<DeputeDataRoot>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(DeputeDataRoot.class))
                .resource(new ClassPathResource((String) jobParameters.get(FILENAME)))
                .name("deputesJsonItemReader")
                .build();
    }

    @Bean
    public ItemProcessor<DeputeDataRoot, DeputeData> processor() {
        return new DeputeItemProcessor();
    }

    @Bean
    public ItemWriter<DeputeData> writer() {
        return new DeputeItemWriter();
    }

    @Bean
    protected Step step1(ItemReader<DeputeDataRoot> reader,
                         ItemProcessor<DeputeDataRoot, DeputeData> processor,
                         ItemWriter<DeputeData> writer) {
        return stepBuilderFactory.get("step1").<DeputeDataRoot, DeputeData> chunk(10)
                .reader(jsonItemReader(null))
                .processor(processor())
                .writer(writer())
                .listener(stepListener())
                .build();
    }

    @Bean
    protected Step step2(Tasklet tasklet) {
        return stepBuilderFactory.get("step2").tasklet(disableDeputesTasklet())
                .build();
    }

    @Bean
    public StepExecutionListener stepListener() {
        return new DeputeStepListener();
    }

    @Bean(name = "importJSONDeputesFile")
    public Job jobGeneral(@Qualifier("step1") Step step1, @Qualifier("step2") Step step2) {
        return jobBuilderFactory
                .get("importDeputesFileToES")
                .start(step1)
//                .next(step2)
                .listener(jobExecutionListener())
                .build();
    }

    @Bean
    public JobExecutionListener jobExecutionListener() {
        return new DeputeBatchListener();
    }

    @Bean
    public Tasklet disableDeputesTasklet(){
        return new DisableDeputeTasklet();
    }

    @Bean
    @StepScope
    public JsonItemReader<DeputeActiviteRoot> jsonActiviteItemReader(@Value("#{jobParameters}") Map jobParameters) {
        return new JsonItemReaderBuilder<DeputeActiviteRoot>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(DeputeActiviteRoot.class))
                .resource(new ClassPathResource((String) jobParameters.get(FILENAME)))
                .name("deputesActiviteJsonItemReader")
                .build();
    }

    @Bean
    public ItemProcessor<DeputeActiviteRoot, DeputeActivite> activiteProcessor() {
        return new DeputeActiviteItemProcessor();
    }

    @Bean
    public ItemWriter<DeputeActivite> activiteWriter() {
        return new DeputeActiviteItemWriter();
    }


    @Bean
    protected Step activiteStep1(ItemReader<DeputeActiviteRoot> reader,
                         ItemProcessor<DeputeActiviteRoot, DeputeActivite> processor,
                         ItemWriter<DeputeActivite> writer) {
        return stepBuilderFactory.get("activiteStep1").<DeputeActiviteRoot, DeputeActivite> chunk(50)
                .reader(jsonActiviteItemReader(null))
                .processor(activiteProcessor())
                .writer(activiteWriter())
                .listener(stepListener())
                .build();
    }

    @Bean(name = "importJSONDeputesActiviteFile")
    public Job jobActivite(@Qualifier("activiteStep1") Step step1) {
        return jobBuilderFactory
                .get("importDeputesActiviteFileToES")
                .start(step1)
                .listener(jobExecutionListener())
                .build();
    }

}
