package com.bharat.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingDemoAspect {

	//@Before("execution(public void add*())") 
	//@Before("execution(boolean add*())") 
	//@Before("execution(* add*())") 
	//@Before("execution(* add*(com.bharat.aopdemo.Account))") 
	//@Before("execution(* add*(..))") 
	@Before("execution(* com.bharat.aopdemo.dao.*.*(..))")
	public void addBeforeAccountAdvice(){
		System.out.println("=========>LoggingDemoAspect: This is an @Before advice");
	}
}
