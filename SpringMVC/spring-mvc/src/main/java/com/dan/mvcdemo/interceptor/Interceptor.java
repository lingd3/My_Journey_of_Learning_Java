package com.dan.mvcdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor implements HandlerInterceptor {

	//返回值:表示我们是否需要将当前的请求拦截下来
	// 如果返回false，请求将被终止
	// 如果返回true，请求会被继续运行
	//Object handler表示的是被拦截的请求的目标对象
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//设置编码
		request.setCharacterEncoding("utf-8");
		System.out.println("执行到了preHandle方法！");
		
		//对用户是否登录进行判断
		if (request.getSession().getAttribute("user") == null) {
			//如果用户没有登录，就终止请求，并发送到登录页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		}
		
		return true;
	}

	//可以通过ModelAndView参数来改变显示的视图，或修改发往视图的方法
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("执行到了postHandle方法！");
		modelAndView.addObject("msg", "这里传回的是被拦截器修改之后的消息！");
		modelAndView.setViewName("hello");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("执行到了afterCompletion方法！");
	}

}



