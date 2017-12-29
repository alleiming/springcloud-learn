package com.allei.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.allei.service.HelloService;

/**
 * @author alleiming 2017/11/1 下午9:58
 */
@FeignClient(value = "HELLO-SERVICE", fallback = FallbackHelloService.class,path="remote")
public interface FeignHelloService extends HelloService {

}
