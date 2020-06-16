package com.ipiecoles.java.elastic.batchs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class DeputeStepListener implements StepExecutionListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void beforeStep(StepExecution stepExecution) {
        stepExecution.getJobExecution();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        logger.info(stepExecution.getJobExecution().getJobConfigurationName()+":"+stepExecution.getJobExecution().getJobId()+":NB_ECRITURES:" + stepExecution.getWriteCount());
        return ExitStatus.COMPLETED;
    }
}
