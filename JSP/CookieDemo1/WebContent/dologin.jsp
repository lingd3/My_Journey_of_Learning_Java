<%@ page language="java" import="java.net.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录成功</h1>
	<hr>
	<br>
	<br>
	<br>
	<%
		request.setCharacterEncoding("utf-8");
		//首先判断用户是否选择了记住登录状态
		String[] isUseCookies = request.getParameterValues("isUseCookie");
		if (isUseCookies != null && isUseCookies.length > 0) {
			//把用户名和密码保存在Cookie对象里面
			String username = URLEncoder.encode(request.getParameter("username"), "utf-8");
			//使用URLEncoding解决无法在Cookie当中保存中文字符串问题
			String password = URLEncoder.encode(request.getParameter("password"), "utf-8");
			Cookie usernameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);
			usernameCookie.setMaxAge(864000);
			passwordCookie.setMaxAge(864000);//设置最大生存期限为10天
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
		}
		else {
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (Cookie c : cookies) {
					if (c.getName().equals("username") || c.getName().equals("password")) {
						c.setMaxAge(0); //设置Cookie失效
						response.addCookie(c); //重新保存
					}
				}
			}
		}
	%>
	<a href="users.jsp" target="_blank">查看用户信息</a>
</body>
</html>













