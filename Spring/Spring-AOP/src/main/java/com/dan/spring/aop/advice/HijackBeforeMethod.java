package com.dan.spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class HijackBeforeMethod implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("HijackBeforeMethod : Before method hijacked!");
	}

}
