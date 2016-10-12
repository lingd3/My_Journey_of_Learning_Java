package com.dao;

import com.po.Users;

//用户的业务逻辑类
public class UsersDAO {
	
	public boolean usersLogin(Users u) {
		if ("admin".equals(u.getUsername()) && "admin".equals(u.getPassword())) return true;
		return false;
	}
}
