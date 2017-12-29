package com.allei;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author alleiming 2017/12/24 下午2:07
 */
//@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServiceApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ConfigServiceApplication.class, args);
        new SpringApplicationBuilder(ConfigServiceApplication.class).web(true).run(args);
    }
}
