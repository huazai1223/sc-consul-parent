package com.jiadonghua.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TestProvider {

    @Autowired
    DiscoveryClient discoveryClient;
    /*负载均衡器*/
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("services")
    public List<String> getServices() {
        List<String> services = discoveryClient.getServices();
        return services;
    }

    @RequestMapping("getservice")
    public List<ServiceInstance> getservice() {
        List<ServiceInstance> provider = discoveryClient.getInstances("provider1");
        return provider;
    }

    @RequestMapping("bcall")
    public String balancecall(){
        ServiceInstance instance = loadBalancerClient.choose("providerName");
        String url = instance.getUri().toString() + "/test";
        RestTemplate template = new RestTemplate();
        String s = template.getForObject(url, String.class);
        System.out.println("return s is"+ s);
        return s;
    }

    @RequestMapping("call")
    public String call() {
        List<ServiceInstance> provider = discoveryClient.getInstances("provider1");
        if (provider != null && provider.size() > 0) {
            RestTemplate template = new RestTemplate();
            ServiceInstance instance = provider.get(0);
            String result = template.getForObject(instance.getUri().toString() + "/test", String.class);
            return result;
        }
        return "no service";
    }
}
