package com.dan.spring.innerBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static ApplicationContext context;

    public static void main( String[] args ) {
        context = new ClassPathXmlApplicationContext("SpringBeans2.xml");
        
        Customer obj = (Customer) context.getBean("CustomerBean");
        System.out.println(obj.toString());
    }
}
