package com.demo.helloworld;

public class HelloWorld {
	
	private String name;
	
	public void setName(String n) {
		name = n;
	}
	
	public void printHello() {
		System.out.println("The first Spring :hello "+name);
	}
}
