package com.allei.service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alleiming 2017/8/6 下午9:45
 */
@RestController
public class HelloController {

    private final Logger    logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    @Value("${server.port}")
    private Integer         port;

    //@Autowired
    //private Registration    registration;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        List<String> serviceList = client.getServices();
        logger.info(serviceList.toString());
        Integer r = a + b;
        return r;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        try {
            TimeUnit.SECONDS.sleep(RandomUtils.nextInt(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello:" + port;
    }
}
