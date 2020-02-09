package com.netloan.fegin.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netloan.fegin.service.hystrix.FeignCredClientHystrix;

@FeignClient(value = "netloan-cred", fallback = FeignCredClientHystrix.class)
public interface FeignCredClient {

	/**
	 * @RequestParam添加註解，保证是Get的请求
	 * @param message
	 * @return
	 */
	// @RequestMapping(value = "/say", method = RequestMethod.GET)
	@GetMapping(value = "/cred/say")
	String say(@RequestParam("message") String message);

	@PostMapping(value = "/cred/put")
	String sayPut(String message);

}
