<%@ page language="java" import="java.text.*, java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>session内置对象</h1>
	<hr>
	<%
	
	%>

	Session的ID编号： <%=session.getId() %> <br>
	从Session中获取用户名：<%=session.getAttribute("username")%><br>
	Session中保存的属性有：<%
						String[] names = session.getValueNames();
						for (int i = 0; i < names.length; i++) {
							out.println(names[i] + "&nbsp;&nbsp;");
						}
	%><br>
</body>
</html>










