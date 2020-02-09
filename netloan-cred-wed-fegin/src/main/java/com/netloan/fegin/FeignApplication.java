package com.netloan.fegin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netloan.fegin.service.AdminService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@ComponentScan(basePackages = { "com.netloan" })
public class FeignApplication {

	@Value("${server.port}")
	private int port;

	@Autowired
	AdminService adminService;

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}

	@GetMapping("/feign/say")
	public String say(String message) {
		return adminService.say(message);
	}
	
	@GetMapping("/feign/put")
	public String sayPut(String message) {
		return adminService.post(message);
	}

}
