package com.dan.servicefeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("hello-service")
public interface SchedualServiceHello {

	@RequestMapping("/hello")
	String hello();
	
}
