package com.allei;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alleiming 2017/12/24 下午10:26
 */
@RefreshScope
@RestController
public class TestConfigController {

    @Value("${env}")
    private String env;

    @RequestMapping("/config")
    public String config() {
        return env;
    }
}
