package com.dan.servicefeign.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dan.servicefeign.service.SchedualServiceHello;

@RestController
public class HelloController {

	@Autowired
	SchedualServiceHello schedualServiceHello;
	
	@RequestMapping(value = "/feign-hello", method = RequestMethod.GET)
	public String sayHello() {
		return schedualServiceHello.hello();
	}
	
}
