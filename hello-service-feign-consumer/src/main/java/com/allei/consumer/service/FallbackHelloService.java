package com.allei.consumer.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.allei.dto.User;

/**
 * Created by Administrator on 2016/9/16.
 */
@Component
public class FallbackHelloService implements HelloService {

    @Override
    public String hello(@RequestBody User user) {
        return "unknown user";
    }

}
