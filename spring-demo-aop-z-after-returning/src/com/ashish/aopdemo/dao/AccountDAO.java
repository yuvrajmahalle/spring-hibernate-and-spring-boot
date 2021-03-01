package com.ashish.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ashish.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	// add a new method : findaccounts()
	
	public List<Account> findAccounts(){
		
		List<Account> myAccounts = new ArrayList<>();
		
		// create sample accounts
		Account temp1 = new Account("Ashish","Prime");
		Account temp2 = new Account("Mahalle","Prime 1");
		Account temp3 = new Account("Ashish Mahalle","Prime 2");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
		
	}
	
	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}

	public String getName() {
		System.out.println("\ngetName");
		return name;
	}

	public void setName(String name) {
		System.out.println("\n setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("\n getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("\n setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	

}
