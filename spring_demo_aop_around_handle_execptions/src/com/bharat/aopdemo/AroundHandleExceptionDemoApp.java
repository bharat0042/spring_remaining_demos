package com.bharat.aopdemo;


import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bharat.aopdemo.dao.AccountDAO;
import com.bharat.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		logger.info("\n\nThis is the main class");
		logger.info("\n\nCalling TrafficFortuneService to get fortune now");
		boolean tripwaire = true;
		logger.info("\n\nFortune is : " + theFortuneService.getFortune(tripwaire));
		logger.info("\n\nDone");
		context.close();
	}
}
