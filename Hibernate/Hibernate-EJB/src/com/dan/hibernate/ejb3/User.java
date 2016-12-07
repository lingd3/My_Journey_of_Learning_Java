package com.dan.hibernate.ejb3;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity 注解可以将一个类声明为一个实体 bean(即一个持久化 POJO 类)
//@Id 注解则声明了该实体 bean 的唯一标识属性（对应数据库主键 key）

@Entity
//@Table(name="")
//数据库中默认会对应生成同名的 Table
//如果要修改 Table 名，使用 @Table(name="")
//"" 内为自定义的 Table 名
public class User {

	private int id;
	private String username;
	private String password;
	
	public User() {}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
