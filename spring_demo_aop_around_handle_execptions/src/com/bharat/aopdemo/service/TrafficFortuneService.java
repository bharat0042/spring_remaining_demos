package com.bharat.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Expect Heavy Traffic";
	}

	public String getFortune(boolean tripwaire) {
		if(tripwaire) {
			throw new RuntimeException("Major Accident, everything is closed");
		}
		return getFortune();
	}
}