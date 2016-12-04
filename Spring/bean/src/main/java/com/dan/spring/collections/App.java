package com.dan.spring.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	
	private static ApplicationContext context;
	
    public static void main( String[] args ) {
    	context = new ClassPathXmlApplicationContext("SpringCollections.xml");
    	
    	//List
    	Customer lists = (Customer)context.getBean("customerBean");
    	System.out.println(lists.getLists().toString());
    	
    	//Set
//    	Customer sets = (Customer)context.getBean("customerBean");
//    	System.out.println(sets.getSets().toString());
    	
    	//Map
//    	Customer maps = (Customer)context.getBean("customerBean");
//    	System.out.println(maps.getMaps().toString());
    	
    	//Property
//    	Customer pros = (Customer)context.getBean("customerBean");
//    	System.out.println(pros.getPros().toString());
    	
    }
}





