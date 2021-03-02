package com.ashish.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashish.aopdemo.dao.AccountDAO;
import com.ashish.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		
		
		 // read spring configuration java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theTrafficFortuneService  =
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		 
		myLogger.info("\n main program : arounddemoapp");
		
		String data = theTrafficFortuneService.getFortune();
		
		myLogger.info("\n My fortune is : " + data);
		
		myLogger.info("Finished");
		
		
		// close the context
		context.close();
	}

}

