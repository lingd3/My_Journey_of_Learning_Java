<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="loginUser" class="com.po.Users" scope="page"/>
<jsp:useBean id="userDAO" class="com.dao.UsersDAO" scope="page"/>
<<jsp:setProperty property="*" name="loginUser"/>
<%
	//如果用户名和密码都等于admin，则登录成功
	if (userDAO.usersLogin(loginUser)) {
		session.setAttribute("loginUser", loginUser.getUsername());
		request.getRequestDispatcher("login_success.jsp").forward(request, response);
	}
	else {
		response.sendRedirect("login_failure.jsp");
	}
%>