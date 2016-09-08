<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String loginUser = "";
		if (session.getAttribute("loginUser") != null) {
			loginUser = session.getAttribute("loginUser").toString();
		}
	%>
	欢迎您<font color="red"><%=loginUser %></font>, 登录成功！
</body>
</html>