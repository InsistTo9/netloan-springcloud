package com.netloan.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "hasError")
	public String remoteSync(String message) {

		return restTemplate.getForObject("http://netloan-cred/cred/say?message=" + message, String.class);

	}

	@HystrixCommand(commandKey = "remote", fallbackMethod = "hasError")
	public String remoteSync1(String message) {

		return restTemplate.postForObject("http://netloan-cred/cred/put", message, String.class);
	}

	public String hasError(String message) {

		return "Server 500 Error";
	}
}
