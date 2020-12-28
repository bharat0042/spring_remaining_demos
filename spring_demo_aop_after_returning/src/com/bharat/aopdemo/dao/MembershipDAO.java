package com.bharat.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": This is addAccount method\n\n");
	}
	
	public boolean addCredit() {
		System.out.println(getClass() + ": This is addCredit method\n\n");
		return true;
	}
}
