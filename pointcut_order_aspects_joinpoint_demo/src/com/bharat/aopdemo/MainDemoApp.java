package com.bharat.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bharat.aopdemo.dao.AccountDAO;
import com.bharat.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		Account theAccount = new Account();
		theAccountDAO.addAccount(theAccount, true);
		theAccountDAO.addCredit();
		theAccountDAO.doWork();
		theAccountDAO.goToSleep();
		theAccountDAO.setName("spring");
		theAccountDAO.setLevel("one");
		theAccountDAO.getLevel();
		theAccountDAO.getName();
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		membershipDAO.addAccount();
		membershipDAO.addCredit();
		
		context.close();
	}
}
