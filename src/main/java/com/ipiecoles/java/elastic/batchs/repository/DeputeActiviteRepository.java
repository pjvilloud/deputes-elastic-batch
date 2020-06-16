package com.ipiecoles.java.elastic.batchs.repository;

import com.ipiecoles.java.elastic.batchs.model.DeputeActivite;
import com.ipiecoles.java.elastic.batchs.model.DeputeData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DeputeActiviteRepository extends ElasticsearchRepository<DeputeActivite, Long> {
}
