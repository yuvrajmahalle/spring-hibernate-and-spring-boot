package com.ashish.springdemo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashish.springdemo.dao.CustomerDAO;
import com.ashish.springdemo.entity.Customer;
import com.ashish.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer Service
	@Autowired
	private CustomerService customerService;
 
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customer from the customerDAO
		List<Customer> theCustomers = customerService.getCustomers();
		
		//and the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
}
