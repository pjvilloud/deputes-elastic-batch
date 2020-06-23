package com.ipiecoles.java.elastic.batchs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import java.time.Duration;

public class DeputeBatchListener implements JobExecutionListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void beforeJob(JobExecution jobExecution) {
        jobExecution.getJobInstance().getJobName();
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info(jobExecution.getJobInstance().getJobName()+":"+jobExecution.getJobId()+":DUREE_TOTALE_SECONDES:" + Duration.ofMillis(jobExecution.getEndTime().getTime() - jobExecution.getStartTime().getTime()).toSecondsPart());
        logger.info(jobExecution.getJobInstance().getJobName()+":"+jobExecution.getJobId()+":STATUT:" + jobExecution.getStatus().getBatchStatus());
    }
}
