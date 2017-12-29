package com.allei;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author alleiming 2017/12/24 下午10:25
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ConfigClientApplication.class, args);
        new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
    }
}
