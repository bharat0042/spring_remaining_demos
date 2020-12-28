package com.bharat.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bharat.aopdemo.dao.AccountDAO;
import com.bharat.aopdemo.dao.MembershipDAO;

public class AfterReturnDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		theAccountDAO.add(new Account("Luca"));
		theAccountDAO.add(new Account("Keanu"));
		List<Account> listAccount = theAccountDAO.findAccounts();
		System.out.println("\n\n From main class ----");
		System.out.println(listAccount);
		context.close();
	}
}
