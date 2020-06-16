package com.ipiecoles.java.elastic.batchs.general;

import com.ipiecoles.java.elastic.batchs.model.DeputeData;
import com.ipiecoles.java.elastic.batchs.repository.DeputeDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DisableDeputeTasklet implements Tasklet {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DeputeDataRepository deputeDataRepository;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        /*List<DeputeData> deputesToDisable = deputeDataRepository.findByLastImportJobIdNotAndActifNot(chunkContext.getStepContext().getJobInstanceId(), true);
        logger.info(chunkContext.getStepContext().getJobInstanceId()+":NB_DEPUTES_DESACTIVES:" + deputesToDisable.size());
        deputesToDisable.forEach(deputeData -> deputeData.setActif(false));
        deputeDataRepository.saveAll(deputesToDisable);*/
        return RepeatStatus.FINISHED;
    }
}
