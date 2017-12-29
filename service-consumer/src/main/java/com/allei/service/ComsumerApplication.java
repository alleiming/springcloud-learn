package com.allei.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author alleiming 2017/8/6 下午9:48
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ComsumerApplication {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
//        SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
//        httpRequestFactory.setReadTimeout(10000);
//        httpRequestFactory.setConnectTimeout(10000);

//        Netty4ClientHttpRequestFactory requestFactory = new Netty4ClientHttpRequestFactory();
//        requestFactory.setReadTimeout(5000);
//        requestFactory.setConnectTimeout(10000);
//        return new RestTemplate(requestFactory);
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ComsumerApplication.class, args);
    }
}
