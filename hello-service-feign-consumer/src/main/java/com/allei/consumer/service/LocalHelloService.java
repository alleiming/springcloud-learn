//package com.allei.consumer.service;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.allei.dto.User;
//
//@FeignClient(name = "HELLO-SERVICE", fallback = FallbackHelloService.class)
//public interface LocalHelloService {
//
//    @RequestMapping(value = "/hello", method = RequestMethod.POST)
//    String hello(@RequestBody User user);
//
//}
