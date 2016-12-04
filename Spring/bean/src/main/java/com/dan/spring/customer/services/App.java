package com.dan.spring.customer.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static ApplicationContext context;

    public static void main( String[] args ) {
        context = new ClassPathXmlApplicationContext("SpringBeans3.xml");
        
        CustomerService cs1 = (CustomerService)context.getBean("CustomerService");
        cs1.setMessage("Message by cs1");
        System.out.println("Message: " + cs1.getMessage());
        
        CustomerService cs2 = (CustomerService)context.getBean("CustomerService");
        System.out.println("Message: " + cs2.getMessage());
    }
}
