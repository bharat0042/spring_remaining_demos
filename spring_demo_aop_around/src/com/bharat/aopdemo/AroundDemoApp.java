package com.bharat.aopdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bharat.aopdemo.dao.AccountDAO;
import com.bharat.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("\n\nThis is the main class");
		System.out.println("\n\nCalling TrafficFortuneService to get fortune now");
		System.out.println("\n\nFortune is : " + theFortuneService.getFortune());
		System.out.println("\n\nDone");
		context.close();
	}
}
