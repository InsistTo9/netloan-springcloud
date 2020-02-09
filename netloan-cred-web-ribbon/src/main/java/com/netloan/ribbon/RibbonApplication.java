package com.netloan.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class RibbonApplication {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {

		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(1000 * 2);// 连接超时时间
		factory.setReadTimeout(1000 * 1);// 读超时时间
		return new RestTemplate(factory);
	}

	public static void main(String[] args) {

		SpringApplication.run(RibbonApplication.class, args);

	}
}
