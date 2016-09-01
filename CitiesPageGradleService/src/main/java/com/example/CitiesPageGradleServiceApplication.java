package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by kostya.nikitin on 9/1/2016.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CitiesPageGradleServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CitiesPageGradleServiceApplication.class, args);
    }
}
