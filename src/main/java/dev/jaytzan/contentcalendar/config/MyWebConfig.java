package dev.jaytzan.contentcalendar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // lookng for been definitions
public class MyWebConfig {

    @Bean
    public RestTemplate restTemplate(){ // client api call out a public Api or Another service
        return new RestTemplateBuilder().build();
    }
}
