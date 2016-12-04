package com.dan.spring.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "SpringAOPAspectj.xml" });
        ICustomerBo customer=(ICustomerBo)appContext.getBean("customerBo");

        customer.addCustomer();

        System.out.println("-------------------------------------------");

        customer.deleteCustomer();

    }
	
}
