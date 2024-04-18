package com.kit.migrator.datamigrator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        // Creating an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Configuring connection timeouts
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); // 5 seconds
        factory.setReadTimeout(5000); // 5 seconds
        restTemplate.setRequestFactory(factory);

        // Additional configurations can be applied here

        return restTemplate;
    }
}
