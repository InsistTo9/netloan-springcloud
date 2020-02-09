package com.netloan.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netloan.ribbon.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/admin")
	public String getAdmin(String message) {

		return adminService.remoteSync(message);
	}

	@GetMapping("/admin1")
	public String getAdmin1(String message) {

		return adminService.remoteSync1(message);
	}

}
