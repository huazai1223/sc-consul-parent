package com.jiadonghua.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BalanceConfig {

    @Bean
    public IRule MyRule(){
        /*指定随机的负载均衡算法*/
        return new RandomRule();
    }
}
