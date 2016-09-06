<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>out内置对象</h1>
	<%
		out.println("<h2>静夜思</h2");
		out.println("床前明月光<br>");
		out.println("疑是地上霜<br>");
		out.flush();
		//out.clear();//这里会抛出异常
		out.clearBuffer();//这里不会抛出异常
		out.println("举头望明月<br>");
		out.println("低头思故乡<br>");
	%>
	缓冲区大小：<%=out.getBufferSize() %>byte<br>
	缓冲区剩余大小：<%=out.getRemaining() %>byte<br>
	是否自动清空缓冲区：<%=out.isAutoFlush() %><br>
</body>
</html>
