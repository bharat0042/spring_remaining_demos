package com.bharat.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.bharat.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String level;

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
	
	public void goToSleep() {
		System.out.println(getClass() + ": This is goToSleep method\n\n");
	}

	public String getName() {
		System.out.println(getClass() + ": This is getName method\n\n");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": This is setName method\n\n");
		this.name = name;
	}

	public String getLevel() {
		System.out.println(getClass() + ": This is getLevel method\n\n");
		return level;
	}

	public void setLevel(String level) {
		System.out.println(getClass() + ": This is setLevel method\n\n");
		this.level = level;
	}
}
