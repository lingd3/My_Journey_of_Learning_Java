package com.dan.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	
	private static ApplicationContext context;
	
    public static void main( String[] args ) {
    	context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        FilenameGenerator obj = (FilenameGenerator) context.getBean("FileNameGenerator");
        obj.printFileName();
    }
}
