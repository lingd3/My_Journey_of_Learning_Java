<%@ page language="java" import="java.io.*, java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=utf-8");//设置响应的MIMI类型
	
	out.println("<h1>response内置对象</h1>");
	out.println("<hr>");
	//out.flush();
	
	PrintWriter outer = response.getWriter();//获得输出流对象
	outer.println("大家好，我是response对象生成的输出流outer对象");
	//response.sendRedirect("register.jsp");//请求重定向
	//请求重定向
	//response.sendRedirect("request.jsp");
	//请求转发
	request.getRequestDispatcher("request.jsp").forward(request, response);
	
	//请求重定向相当于两次请求，地址栏地址会发生变化
	//重定向是response对象的方法而请求转发是request对象的方法
	//请求重定向是客户端行为而请求转发是服务器行为
	//请求重定向不会保存原有request对象而请求转发会保存原有request对象
%>
