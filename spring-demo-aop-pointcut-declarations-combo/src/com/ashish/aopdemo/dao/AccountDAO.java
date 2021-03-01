package com.ashish.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.ashish.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
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
