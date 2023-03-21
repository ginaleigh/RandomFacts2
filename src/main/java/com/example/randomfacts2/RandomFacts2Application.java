package com.example.randomfacts2;

import com.example.randomfacts2.service.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class RandomFacts2Application {

    public static void main(String[] args) {
        SpringApplication.run(RandomFacts2Application.class, args);
    }


}

