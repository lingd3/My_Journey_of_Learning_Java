package com.dan.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect2 {
	
	@Before("com.dan.spring.aop.aspectj.PointcutsDefinition.customerLog()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("logBefore() is running...");
		System.out.println("hijacked:" + joinPoint.getSignature().getName());
		System.out.println("**********");
	}
	
	@After("com.dan.spring.aop.aspectj.PointcutsDefinition.customerLog()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("logAfter() is running ...");
        System.out.println("hijacked:"+joinPoint.getSignature().getName());
        System.out.println("**********");
    }
}

