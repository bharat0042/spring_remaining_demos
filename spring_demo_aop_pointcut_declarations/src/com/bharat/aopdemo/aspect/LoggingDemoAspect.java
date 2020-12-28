package com.bharat.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingDemoAspect {
	
	@Pointcut("execution(* com.bharat.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {
	}
	
	@Pointcut("execution(* com.bharat.aopdemo.dao.*.get*(..))")
	private void getter() {
	}
	
	@Pointcut("execution(* com.bharat.aopdemo.dao.*.set*(..))")
	private void setter() {
	}
	
	@Pointcut("forDAOPackage() && !(getter() || setter() )")
	private void forDAOPackageWithoutGetterOrSetter() {
	}

	//@Before("execution(public void add*())") 
	//@Before("execution(boolean add*())") 
	//@Before("execution(* add*())") 
	//@Before("execution(* add*(com.bharat.aopdemo.Account))") 
	//@Before("execution(* add*(..))") 
	//@Before("execution(* com.bharat.aopdemo.dao.*.*(..))")
	@Before("forDAOPackageWithoutGetterOrSetter()")
	public void addBeforeAccountAdvice(){
		System.out.println("=========>LoggingDemoAspect: This is an @Before advice");
	}
	
	@Before("forDAOPackage()")
	public void performAPIAnalytics(){
		System.out.println("=========>LoggingDemoAspect: Doing performAPIAnalytics");
	}
}
