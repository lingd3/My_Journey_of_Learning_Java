package com.dan.spring.aop.aspectj;

public class CustomerBo implements ICustomerBo {

	public void addCustomer() {
		System.out.println("addCustomer() is running...");
	}

	public void deleteCustomer() {
		System.out.println("deleteCustomer() is running ...");
	}

	public String AddCustomerReturnValue() {
		System.out.println("AddCustomerReturnValue() is running ...");
        return "abc";
	}

	public void addCustomerThrowException() throws Exception {
		System.out.println("addCustomerThrowException() is running ...");
        throw new Exception("Generic Error");
	}

	public void addCustomerAround(String name) {
		System.out.println("addCustomerAround() is running ,args:"+name);
	}

}


