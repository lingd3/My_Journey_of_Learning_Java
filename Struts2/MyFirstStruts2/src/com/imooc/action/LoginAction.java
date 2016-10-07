package com.imooc.action;

import com.imooc.po.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

	User user = new User();

	public String login() {
		
		System.out.println(user.getUsername());
		System.out.println(user.getBookList().get(0));
		System.out.println(user.getBookList().get(1));
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (user.getUsername() == null || "".equals(user.getUsername())) {
			this.addFieldError("username", "用户名不能为空");
		}
	}
	
	@Override
	public User getModel() {
		return user;
	}
}













