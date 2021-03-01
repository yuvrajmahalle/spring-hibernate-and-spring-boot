package com.ashish.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashish.aopdemo.dao.AccountDAO;
import com.ashish.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		 // read spring configuration java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
				
		// call the business method
		Account theAccount = new Account();
		
		theAccount.setName("Ashish");
		theAccount.setLevel("Prime");
		
		theAccountDAO.addAccount(theAccount);
		
		theAccountDAO.setName("Ashish");
		theAccountDAO.setServiceCode("TES1");
		
		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
						
		// close the context
		context.close();
	}

}

