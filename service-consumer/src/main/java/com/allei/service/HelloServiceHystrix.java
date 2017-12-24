package com.allei.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author alleiming 2017/12/23 上午12:03
 */
@Service
public class HelloServiceHystrix {


    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(){
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    public String helloFallback(){
        return "error";
    }
}
