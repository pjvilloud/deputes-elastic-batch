package com.ipiecoles.java.elastic.batchs.activite;

import com.ipiecoles.java.elastic.batchs.BatchImportConfig;
import com.ipiecoles.java.elastic.batchs.model.DeputeActivite;
import com.ipiecoles.java.elastic.batchs.model.DeputeActiviteRoot;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;

import java.util.Calendar;
import java.util.Date;

public class DeputeActiviteItemProcessor implements ItemProcessor<DeputeActiviteRoot, DeputeActivite> {

    private String activiteYearMonth;

    @Override
    public DeputeActivite process(DeputeActiviteRoot item) throws Exception {
        DeputeActivite deputeActivite = item.getDepute();
        deputeActivite.setId(activiteYearMonth + "_" + item.getDepute().getId());
        deputeActivite.setDate(activiteYearMonth);
        return deputeActivite;
    }

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        activiteYearMonth = stepExecution.getJobParameters().getString(BatchImportConfig.FILENAME).replace("nosdeputes.fr_","").replace("_stats_deputes.json","");
    }
}
