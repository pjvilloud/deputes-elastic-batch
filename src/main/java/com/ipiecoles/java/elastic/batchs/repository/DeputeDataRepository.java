package com.ipiecoles.java.elastic.batchs.repository;

import com.ipiecoles.java.elastic.batchs.model.DeputeData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface DeputeDataRepository extends ElasticsearchRepository<DeputeData, Long> {
   // @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
    //List<DeputeData> findByLastImportJobIdNotAndActifNot(Long jobId, Boolean actif);
}
