package com.dan.mvcdemo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {
	
	@RequestMapping("/mvc")
	public String helloMvc(Map<String, String> model) {
		model.put("msg", "从helloMvc方法传回视图的数据");
		System.out.println("hello");
		return "home";
	}
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("tesing...");
		return "home";
	}
}
