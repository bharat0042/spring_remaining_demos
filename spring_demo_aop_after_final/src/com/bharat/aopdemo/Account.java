package com.bharat.aopdemo;

public class Account {

	private String name;

	public Account(String name) {
		this.name = name;
	}

	public Account() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + "]";
	}
	
}
