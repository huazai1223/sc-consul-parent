package com.jiadonghua.config;

import com.jiadonghua.config.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MyConfig.class)
public class StartConsulConfig {
    public static void main(String[] args) {
        SpringApplication.run(StartConsulConfig.class);
    }
}
