package com.ashish.springdemo.dao;

import java.util.List;

import com.ashish.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
