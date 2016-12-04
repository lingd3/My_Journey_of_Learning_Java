package com.dan.spring.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dan.spring.services.CustomerService;

public class App {

	public static void main( String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"SpringCustomer2.xml"});

        CustomerService cust = (CustomerService)context.getBean("customerService");
        System.out.println(cust);

    }
	
}
