package com.allei.service.contorller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.allei.dto.User;
import com.allei.service.HelloService;

@RestController
public class HelloServiceController implements HelloService {

    @Override
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }

}
