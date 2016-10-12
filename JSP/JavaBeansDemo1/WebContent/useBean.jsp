<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="myUsers" class="com.po.Users" scope="page" />
	<h1>使用useBean动作创建javabean的实例</h1>
	用户名：<%=myUsers.getUsername() %><br>
	密码：<%=myUsers.getPassword() %><br>
</body>
</html>