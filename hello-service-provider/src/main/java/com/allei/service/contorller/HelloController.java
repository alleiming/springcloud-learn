package com.allei.service.contorller;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allei.dto.User;

@RestController
public class HelloController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
    private DiscoveryClient client;

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(@RequestBody User user) {
		ServiceInstance instance = client.getLocalServiceInstance();
		try {
			TimeUnit.SECONDS.sleep(2l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("/hello3, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
		return "Hello "+ user.getName() + ", " + user.getAge();
	}

}