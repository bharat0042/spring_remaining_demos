package com.bharat.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoggingDemoAspect {

	//@Before("execution(public void add*())") 
	//@Before("execution(boolean add*())") 
	//@Before("execution(* add*())") 
	//@Before("execution(* add*(com.bharat.aopdemo.Account))") 
	//@Before("execution(* add*(..))") 
	//@Before("execution(* com.bharat.aopdemo.dao.*.*(..))")
	@Before("com.bharat.aopdemo.aspect.AOPDemoExpressions.forDAOPackageWithoutGetterOrSetter()")
	public void addBeforeAccountAdvice(JoinPoint theJoinPoint){
		
		MethodSignature theSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("\n\ntheSignature : " + theSignature);
		Object[] args = theJoinPoint.getArgs();
		for(Object temp : args) {
			System.out.println("\n\nargs : " + temp);
		}
		System.out.println("=========>LoggingDemoAspect: This is an @Before advice");
	}
}
