package com.netloan.ribbon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.netloan.ribbon.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RibbonApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppTest {

	@Autowired
	AdminService adminService;

	@Test
	public void test1() {
		adminService.remoteSync("hello ");
	}
}
