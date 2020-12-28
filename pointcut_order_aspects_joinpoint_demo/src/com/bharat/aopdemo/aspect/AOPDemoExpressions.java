package com.bharat.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPDemoExpressions {

	@Pointcut("execution(* com.bharat.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {
	}
	
	@Pointcut("execution(* com.bharat.aopdemo.dao.*.get*(..))")
	public void getter() {
	}
	
	@Pointcut("execution(* com.bharat.aopdemo.dao.*.set*(..))")
	public void setter() {
	}
	
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDAOPackageWithoutGetterOrSetter() {
	}
	
}
