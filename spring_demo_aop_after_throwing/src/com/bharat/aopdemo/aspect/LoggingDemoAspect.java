package com.bharat.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bharat.aopdemo.Account;

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
	
	@AfterReturning(pointcut = "execution(* com.bharat.aopdemo.dao.AccountDAO.findAccounts(..))",
			                     returning = "result")
	public void afterReturnAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("-----method is : " + method);
		System.out.println("=========>LoggingDemoAspect: This is an afterReturnAdvice method");
		System.out.println("------return is : " + result);
		System.out.println("=========>LoggingDemoAspect: modifying the data");
		result.get(0).setName("Bharat");
		System.out.println("------return is : " + result);
	}
	
	@AfterThrowing(pointcut = "execution(* com.bharat.aopdemo.dao.AccountDAO.findAccounts(..))",
			                  throwing = "theExc")
	public void afterThrowingExceptionAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("-----method is : " + method);
		System.out.println("=========>LoggingDemoAspect: This is an afterThrowingExceptionAdvice method"); 
		System.out.println("\n\n Aspect method  afterThrowingExceptionAdvice is catching the exception : " + theExc);
	}
}
