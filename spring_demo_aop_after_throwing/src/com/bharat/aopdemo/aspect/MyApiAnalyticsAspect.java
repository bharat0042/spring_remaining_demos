package com.bharat.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyApiAnalyticsAspect {
	
	@Before("com.bharat.aopdemo.aspect.AOPDemoExpressions.forDAOPackageWithoutGetterOrSetter()")
	public void performAPIAnalytics(){
		System.out.println("=========>LoggingDemoAspect: Doing performAPIAnalytics");
	}
}
