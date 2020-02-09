package com.netloan.fegin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netloan.fegin.config.FeignCredClient;
import com.netloan.fegin.service.AdminService;

@Service(value = "adminServiceImpl")
public class AdminServiceImpl implements AdminService {

	@Autowired
	FeignCredClient feignCredClient;

	@HystrixCommand(fallbackMethod = "hasError")
	public String say(String message) {

		return feignCredClient.say(message);
	}

	public String hasError(String message) {

		return "hystrix";
	}

	public String post(String message) {

		return feignCredClient.sayPut(message);
	}
}
