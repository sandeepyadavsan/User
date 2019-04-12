package com.user.main.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UserServiceInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception
	{
		String req=request.getRequestURI().toString();
		
		System.out.println("PreHandler Executed..."+req);
		return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception
	{
		System.out.println("PostHandler Executed..");
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler,Exception exception) throws Exception
	{
		System.out.println("AfterCompletion Executed..");
		
	}

}
