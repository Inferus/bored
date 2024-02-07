package com.upstream_mobility_itacademy.bored.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    private String baseUrl = "https://www.boredapi.com/api/activity";

    @Bean
    public WebClient webClient() {
        return WebClient.create(baseUrl);
    }
}
