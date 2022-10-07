package com.extrawest.aggregateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AggregateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AggregateServiceApplication.class, args);
    }

}
