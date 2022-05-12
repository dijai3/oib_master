package com.ikea.oibmb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import org.springframework.beans.factory.annotation.Value;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@SpringBootApplication
public class OibMbBonusLogicApplication {

    public static void main(String[] args) {

        SpringApplication.run(OibMbBonusLogicApplication.class, args);

    }

    @Value("${spring.cloud.gcp.project-id}")
    private String projectId;

    @Bean
    public BigQuery getInstance() throws IOException {

        BigQuery bigQuery = BigQueryOptions.newBuilder().setProjectId(projectId)
                .build().getService();
        return bigQuery;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Storage getStorageInstance() {
        return StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    }

}
