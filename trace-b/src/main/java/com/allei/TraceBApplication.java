package com.allei;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author alleiming 2017/12/27 下午9:00
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class TraceBApplication {

    private final Logger logger = Logger.getLogger(getClass());

    //	@Bean
    //	public AlwaysSampler defaultSampler() {
    //		return new AlwaysSampler();
    //	}

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/trace-b", method = RequestMethod.GET)
    public String trace() throws InterruptedException {
        logger.info("call trace-b----->");
		TimeUnit.SECONDS.sleep(RandomUtils.nextInt(2));
        return restTemplate().getForEntity("http://trace-c/trace-c", String.class).getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(TraceBApplication.class, args);
    }

}
