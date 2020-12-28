package com.bharat.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAspect {

	@Before("com.bharat.aopdemo.aspect.AOPDemoExpressions.forDAOPackageWithoutGetterOrSetter()")
	public void logToCloud(){
		System.out.println("=========>LoggingDemoAspect: Logging to cloud");
	}
}
