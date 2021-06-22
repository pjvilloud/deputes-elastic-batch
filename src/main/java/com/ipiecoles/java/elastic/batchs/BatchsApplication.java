package com.ipiecoles.java.elastic.batchs;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableElasticsearchRepositories(basePackages = "com.ipiecoles.java.elastic.batchs.repository")

public class BatchsApplication {

	@Bean
	public RestHighLevelClient client() {
		ClientConfiguration clientConfiguration
				= ClientConfiguration.builder()
				.connectedTo("pjvilloud-elastic.es.us-west1.gcp.cloud.es.io:9243")
				//.connectedTo("f1a1408f838a4e3aaf68ec4cf1b665f7.eu-west-2.aws.cloud.es.io:9243")
				.usingSsl()
				.withBasicAuth("elastic", "H3VCkR8qnHL7WVuTqv5j34An")
				.build();

		return RestClients.create(clientConfiguration).rest();
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchRestTemplate(client());
	}

	public static void main(String[] args) {
		SpringApplication.run(BatchsApplication.class, args);
	}

}
