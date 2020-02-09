package com.netloan.zuul.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 
 * @author lixh
 * @see 实现用户认证授权
 *
 */
@Component
public class LoginFilter extends ZuulFilter {

	public boolean shouldFilter() {

		return true;
	}

	/**
	 ** 实现过滤器的具体逻辑
	 */
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();

		HttpServletRequest request = ctx.getRequest();

		HttpServletResponse response = ctx.getResponse();

		String token = request.getParameter("token");

		if (token == null) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			try {
				response.getWriter().write("权限不足");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @see FilterConstants.PRE_TYPE 路由之前
	 * @see FilterConstants.ERROR_TYPE 出现错误
	 * @see FilterConstants.POST_TYPE 路由之后
	 * @see FilterConstants.ROUTE_TYPE 路由之时
	 */
	@Override
	public String filterType() {

		return FilterConstants.PRE_TYPE;

	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
