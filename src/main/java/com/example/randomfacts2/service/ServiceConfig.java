package com.example.randomfacts2.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api")
//@ConstructorBinding
public class ServiceConfig {
    String apiKey = "";

}
