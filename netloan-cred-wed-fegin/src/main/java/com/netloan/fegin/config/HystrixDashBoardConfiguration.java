package com.netloan.fegin.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
public class HystrixDashBoardConfiguration {

	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {

		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(
				streamServlet);
		registrationBean.addUrlMappings("/actuator/hystrix.stream");
		registrationBean.setLoadOnStartup(1);
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}
}
