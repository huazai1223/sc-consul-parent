package com.jiadonghua.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StartProvider1 {

    public static void main(String[] args) {
        SpringApplication.run(StartProvider1.class);
    }
}
