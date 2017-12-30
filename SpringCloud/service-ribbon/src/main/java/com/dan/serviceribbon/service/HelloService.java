package com.dan.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "hiError")
	public String hiService() {
		return restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class);
	}
	
	public String hiError() {
		return "Sorry, error!";
	}
	
}
