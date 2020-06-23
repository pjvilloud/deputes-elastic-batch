package com.ipiecoles.java.elastic.batchs.general;

import com.ipiecoles.java.elastic.batchs.model.DeputeData;
import com.ipiecoles.java.elastic.batchs.repository.DeputeDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeputeItemWriter implements ItemWriter<DeputeData> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DeputeDataRepository deputeDataRepository;

    private Long jobId;
    private String jobName;

    @Override
    public void write(List<? extends DeputeData> items) throws Exception {
        logger.info(jobName+":"+jobId+":WRITE_DEPUTES:"+items.size());
        deputeDataRepository.saveAll(items);
    }

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        jobName = stepExecution.getJobExecution().getJobInstance().getJobName();
        jobId = stepExecution.getJobExecution().getJobId();
    }
}
