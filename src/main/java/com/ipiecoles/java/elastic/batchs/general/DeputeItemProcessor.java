package com.ipiecoles.java.elastic.batchs.general;

import com.ipiecoles.java.elastic.batchs.model.DeputeDataRoot;
import com.ipiecoles.java.elastic.batchs.model.DeputeData;
import org.springframework.batch.item.ItemProcessor;

public class DeputeItemProcessor implements ItemProcessor<DeputeDataRoot, DeputeData> {

    @Override
    public DeputeData process(DeputeDataRoot item) throws Exception {
        DeputeData deputeData = item.getDepute();
        deputeData.setNbMandatsTotal(deputeData.getAnciensMandats().size());
        deputeData.setActif(true);
        if(deputeData.getAncienDepute() != null && deputeData.getAncienDepute().equals(1)){
            deputeData.setActif(false);
        }
        return deputeData;
    }

}
