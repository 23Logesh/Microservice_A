package com.example.Service_A.utility;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    ModelMapper modelMapper;

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }

}
