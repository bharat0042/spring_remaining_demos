package com.bharat.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bharat.aopdemo.dao.AccountDAO;
import com.bharat.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		theAccountDAO.add(new Account("Luca"));
		theAccountDAO.add(new Account("Keanu"));
		List<Account> listAccount = null;
		try {
			boolean tripWire = true;
			listAccount = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\n Main class ....Exception thrown : " + e);
		}
		System.out.println("\n\n From main class ----");
		System.out.println(listAccount);
		context.close();
	}
}
