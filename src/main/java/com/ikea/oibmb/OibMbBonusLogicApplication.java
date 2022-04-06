package com.ikea.oibmb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;

@SpringBootApplication
public class OibMbBonusLogicApplication {
    public static void main(String[] args) {
        SpringApplication.run(OibMbBonusLogicApplication.class, args);
    }

    @Bean
    public BigQuery test(){
        // Initialize client that will be used to send requests. This client only needs to be created
            // once, and can be reused for multiple requests.
            return BigQueryOptions.getDefaultInstance().getService();
    }

}
