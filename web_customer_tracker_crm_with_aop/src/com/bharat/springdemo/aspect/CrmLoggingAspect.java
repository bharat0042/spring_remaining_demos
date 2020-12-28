package com.bharat.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class CrmLoggingAspect {

	@Pointcut("execution(* com.bharat.springdemo.controller.*.*(..))")
	public void forControllerPackage() {
	}
	
	@Pointcut("execution(* com.bharat.springdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}
	
	@Pointcut("execution(* com.bharat.springdemo.service.*.*(..))")
	public void forServicePackage() {
	}
	
	@Pointcut("forDaoPackage() || forServicePackage()")
	public void appFlow() {
	}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	public void mAppFlow() {
	}
	
	@Before("appFlow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		System.out.println("=====>> in @Before: calling method: " + theMethod);
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args) {
			System.out.println("=====>> argument: " + tempArg);
		}
		
	}
	
	@AfterReturning( pointcut="appFlow()", returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
	    String theMethod = theJoinPoint.getSignature().toShortString();
		System.out.println("=====>> in @AfterReturning: from method: " + theMethod);
		System.out.println("=====>> result: " + theResult);
	}
}
