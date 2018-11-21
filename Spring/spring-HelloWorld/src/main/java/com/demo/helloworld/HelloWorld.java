package com.demo.helloworld;

public class HelloWorld {
	
	private String name;

	private double num;
	
	public HelloWorld(String name, double num) {
		this.name = name;
		this.num = num;
	}
	
//	public HelloWorld(double num, String name) {
//		this.name = name;
//		this.num = num;
//	}
	
	public void printHello() {
		System.out.println(name + " - " + num);
	}
}
