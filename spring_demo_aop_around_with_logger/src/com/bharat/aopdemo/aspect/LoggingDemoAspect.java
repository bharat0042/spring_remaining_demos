package com.bharat.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private static Logger logger = Logger.getLogger(LoggingDemoAspect.class.getName());

	//@Before("execution(public void add*())") 
	//@Before("execution(boolean add*())") 
	//@Before("execution(* add*())") 
	//@Before("execution(* add*(com.bharat.aopdemo.Account))") 
	//@Before("execution(* add*(..))") 
	//@Before("execution(* com.bharat.aopdemo.dao.*.*(..))")
	@Before("com.bharat.aopdemo.aspect.AOPDemoExpressions.forDAOPackageWithoutGetterOrSetter()")
	public void addBeforeAccountAdvice(JoinPoint theJoinPoint){
		
		MethodSignature theSignature = (MethodSignature) theJoinPoint.getSignature();
		logger.info("\n\ntheSignature : " + theSignature);
		Object[] args = theJoinPoint.getArgs();
		for(Object temp : args) {
			logger.info("args : " + temp);
		}
		logger.info("=========>LoggingDemoAspect: This is an @Before advice");
	}
	
	@AfterReturning(pointcut = "execution(* com.bharat.aopdemo.dao.AccountDAO.findAccounts(..))",
			                     returning = "result")
	public void afterReturnAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();
		//logger.info("-----method is : " + method);
		logger.info("=========>LoggingDemoAspect: This is an afterReturnAdvice method");
		//logger.info("------return is : " + result);
		logger.info("=========>LoggingDemoAspect: modifying the data");
		result.get(0).setName("Bharat");
		//logger.info("------return is : " + result);
	}
	
	@AfterThrowing(pointcut = "execution(* com.bharat.aopdemo.dao.AccountDAO.findAccounts(..))",
			                  throwing = "theExc")
	public void afterThrowingExceptionAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method = theJoinPoint.getSignature().toShortString();
		//logger.info("\n\n-----method is : " + method);
		logger.info("=========>LoggingDemoAspect: This is an afterThrowingExceptionAdvice method"); 
		logger.info("Aspect method  afterThrowingExceptionAdvice is catching the exception : " + theExc);
	}
	
	@After("execution(* com.bharat.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		//logger.info("\n\n-----method is : " + method);
		logger.info("=========>LoggingDemoAspect: This is an afterFinallyAdvice method"); 
	}
	
	@Around("execution(* com.bharat.aopdemo.service.*.getFortune(..))")
	public Object aroundGetService(ProceedingJoinPoint thePoint) throws Throwable {
		String method = thePoint.getSignature().toShortString();
		logger.info("\n\nExecuting @Around on method : " + method);
		long begin = System.currentTimeMillis();
		Object returnObject = thePoint.proceed();
		long end = System.currentTimeMillis();
		long duration = end - begin;
		logger.info("\n\nExecuting @Around on method took around : " + duration/1000 + " seconds");
		return returnObject;
	}
}
