package com.netloan.zuul.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 
 * @author: lixh
 * @date: 2020年02月04日
 * @Descption: FallBack用于定制返回的Body,Status,消息头Header
 */
@Component
public class CommFallbackProvider implements FallbackProvider {

	static final Logger logger = LoggerFactory.getLogger(CommFallbackProvider.class);

	/**
	 * * 微服务配置了路由,返回路由名称,如果所有采用同样的处理机制,可返回空或者“*”
	 * 
	 * @return server-id
	 */

	public String getRoute() {

		return "netloan-cred";

	}

	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

		logger.error(route, cause);

		// TODO Auto-generated method stub
		return new ClientHttpResponse() {

			public InputStream getBody() throws IOException {

				return new ByteArrayInputStream(
						String.format("%s server call fail , please checking ", CommFallbackProvider.this.getRoute())
								.getBytes());

			}

			public HttpHeaders getHeaders() {

				HttpHeaders headers = new HttpHeaders();

				headers.setContentType(MediaType.APPLICATION_JSON);

				return headers;
			}

			public HttpStatus getStatusCode() throws IOException {

				return HttpStatus.OK;
			}

			public int getRawStatusCode() throws IOException {

				return 200;
			}

			public String getStatusText() throws IOException {

				return String.format("%s server call fail , please checking ", CommFallbackProvider.this.getRoute());
			}

			public void close() {

			};
		};
	}
}
