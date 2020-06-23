package com.ipiecoles.java.elastic.batchs.general;

import com.ipiecoles.java.elastic.batchs.model.DeputeDataRoot;
import com.ipiecoles.java.elastic.batchs.model.DeputeData;
import com.ipiecoles.java.elastic.batchs.repository.DeputeDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DeputeItemProcessor implements ItemProcessor<DeputeDataRoot, DeputeData> {

    @Autowired
    DeputeDataRepository deputeDataRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Long jobId;
    private String jobName;

    @Override
    public DeputeData process(DeputeDataRoot item) throws Exception {
        DeputeData depute = null;
        Optional<DeputeData> deputeData = deputeDataRepository.findById(item.getDepute().getId());
        if(deputeData.isPresent()){
            //Député existant, on met à jour uniquement les stats
            depute = deputeData.get();
            depute.setSemainesPresence(item.getDepute().getSemainesPresence());
            depute.setCommissionPresences(item.getDepute().getCommissionPresences());
            depute.setCommissionInterventions(item.getDepute().getCommissionInterventions());
            depute.setHemicycleInterventions(item.getDepute().getHemicycleInterventions());
            depute.setHemicycleInterventionsCourtes(item.getDepute().getHemicycleInterventionsCourtes());
            depute.setAmendementsProposes(item.getDepute().getAmendementsProposes());
            depute.setAmendementsSignes(item.getDepute().getAmendementsSignes());
            depute.setAmendementsAdoptes(item.getDepute().getAmendementsAdoptes());
            depute.setRapports(item.getDepute().getRapports());
            depute.setPropositionsEcrites(item.getDepute().getPropositionsEcrites());
            depute.setPropositionsSignees(item.getDepute().getPropositionsSignees());
            depute.setQuestionsEcrites(item.getDepute().getQuestionsEcrites());
            depute.setQuestionsOrales(item.getDepute().getQuestionsOrales());
        } else {
            //Députés inexistant, on enregistre tout
            logger.warn(jobName+":"+jobId+":NOUVEAU_DEPUTE:"+item.getDepute().getId());

            depute = item.getDepute();
        }
        depute.setNbMandatsTotal(item.getDepute().getAnciensMandats().size());
        depute.setActif(true);
        if(item.getDepute().getAncienDepute() != null && item.getDepute().getAncienDepute().equals(1)){
            depute.setActif(false);
        }
        return depute;
    }

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        jobName = stepExecution.getJobExecution().getJobInstance().getJobName();
        jobId = stepExecution.getJobExecution().getJobId();
    }

}
