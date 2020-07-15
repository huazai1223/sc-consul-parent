package com.jiadonghua.consumer;

import com.jiadonghua.consumer.config.BalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name="providerName",configuration = {BalanceConfig.class})
public class StartConsumer {
    public static void main(String[] args) {
        SpringApplication.run(StartConsumer.class);
    }
}
