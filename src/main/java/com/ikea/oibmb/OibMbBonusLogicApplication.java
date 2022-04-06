package com.ikea.oibmb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import org.springframework.beans.factory.annotation.Value;

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

}
