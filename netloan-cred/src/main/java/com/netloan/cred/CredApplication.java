package com.netloan.cred;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class CredApplication {
	private static final Logger logger = LoggerFactory.getLogger(CredApplication.class);

	@Value("${server.port}")
	private int port;

	@GetMapping("/cred/say")
	public String say(String message) throws InterruptedException {
		logger.info("revice messge:" + message);

		Thread.sleep(15000);

		return String.format("Hello Spring Cloud: %s port %s", message, port);
	}

	@PostMapping("/cred/put")
	public String sayPut(String message) throws InterruptedException {

		logger.info("revice put messge:" + message);

		Thread.sleep(15000);

		return String.format("Hello Spring Cloud: %s port %s", message, port);
	}

	public static void main(String[] args) {
		SpringApplication.run(CredApplication.class, args);
	}
}
