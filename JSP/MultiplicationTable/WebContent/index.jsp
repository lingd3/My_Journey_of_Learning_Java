<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>九九乘法表</h1>
	<hr>
	<p>用脚本实现：</p>
	<%
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				out.print(i + "*" + j + "=" + (i*j) + " ");
			}
			out.println("<br>");
		}
	%>
	<p>用表达式实现：</p>
	<%!
		public String printTable() {
			String a = "";
			for (int i = 1; i < 10; i++) {
				for (int j = 1; j <= i; j++) {
					a += (i + "*" + j + "=" + (i*j) + " ");
				}
				a += "<br>";
			}
			return a;
		}
	%>
	<%= printTable()%>
	
</body>
</html>