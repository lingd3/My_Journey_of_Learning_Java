package com.dan.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.spring.dao.CustomerDAO;

@Service
public class CustomerService {

	@Autowired
	CustomerDAO customerDAO;

    @Override
    public String toString() {
        return "CustomerService [customerDAO=" + customerDAO + "]";
    }
}
