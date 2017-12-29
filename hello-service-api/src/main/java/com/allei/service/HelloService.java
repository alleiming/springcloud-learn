package com.allei.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.allei.dto.User;

/**
 * Created by alleiming on 2017/11/20.
 */
@RequestMapping("/hello-service")
public interface HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    String hello(@RequestBody User user);

}
