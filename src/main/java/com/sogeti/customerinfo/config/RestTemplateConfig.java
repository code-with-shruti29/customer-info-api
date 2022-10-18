package com.sogeti.customerinfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * Configuration class for getting an instance of RestTemplate
 *
 * @author  Shruti Gautam
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
