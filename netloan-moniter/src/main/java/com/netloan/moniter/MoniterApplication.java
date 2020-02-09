package com.netloan.moniter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class MoniterApplication {

	public static void main(String[] args) {

		SpringApplication.run(MoniterApplication.class, args);

	}
}
