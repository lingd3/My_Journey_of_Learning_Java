package com.dan.spring.aop.aspectj;

public interface ICustomerBo {
	
	void addCustomer();
    void deleteCustomer();
    String AddCustomerReturnValue();
    void addCustomerThrowException() throws Exception;
    void addCustomerAround(String name);
    
}
