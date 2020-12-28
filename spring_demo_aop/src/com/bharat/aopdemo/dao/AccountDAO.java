package com.bharat.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.bharat.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean theFlag) {
		System.out.println(getClass() + ": This is addAccount method\n\n");
	}
	
	public void addCredit() {
		System.out.println(getClass() + ": This is addCredit method\n\n");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": This is doWork method\n\n");
		return false;
	}
}
