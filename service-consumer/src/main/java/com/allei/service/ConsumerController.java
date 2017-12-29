package com.allei.service;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author alleiming 2017/8/6 下午9:45
 */
@RestController
public class ConsumerController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private HelloServiceHystrix helloServiceHystrix;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("http://localhost:8081/hello", String.class).getBody();
    }

    @RequestMapping(value = "/helloRobbin", method = RequestMethod.GET)
    public String helloRobbin() {
        //return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
        return helloServiceHystrix.hello();
    }
}
