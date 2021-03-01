package com.ashish.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashish.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		 // read spring configuration java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;
		
		try {
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch(Exception exc) {
			System.out.println("\n\n Main Program ... caught exception " + exc);
		}
		
		
		
		// display the accounts
		
		System.out.println("\n\n Main program : After throwing demo app");
		
		System.out.println(theAccounts);
						
		// close the context
		context.close();
	}

}

