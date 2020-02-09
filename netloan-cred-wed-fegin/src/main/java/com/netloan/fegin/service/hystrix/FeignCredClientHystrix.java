package com.netloan.fegin.service.hystrix;

import org.springframework.stereotype.Component;

import com.netloan.fegin.config.FeignCredClient;

@Component
public class FeignCredClientHystrix implements FeignCredClient {

	public String say(String message) {

		return String.format("Hi,%s Server stop", message);
	}

	public String sayPut(String message) {

		return String.format("Hi,%s Put Server stop", message);
	}
}
