package com.ashish.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashish.aopdemo.dao.AccountDAO;
import com.ashish.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		 // read spring configuration java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theTrafficFortuneService  =
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		 
		System.out.println("\n main program : arounddemoapp");
		
		String data = theTrafficFortuneService.getFortune();
		
		System.out.println("\n My fortune is : " + data);
		
		System.out.println("Finished");
		
		
		// close the context
		context.close();
	}

}

