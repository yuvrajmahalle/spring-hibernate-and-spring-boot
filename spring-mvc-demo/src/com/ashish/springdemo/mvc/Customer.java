package com.ashish.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ashish.springdemo.mvc.validation.MyCustomAnnotation;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=0,message="number must be more less than 10 and more than 0")
	@Max(value=10,message="number must be more less than 10 and more than 0")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 char/digit")
	private String postalCode;
	    
	
	@MyCustomAnnotation(value="TOP", message="must start with TOP")
	private String customCode;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCustomCode() {
		return customCode;
	}
	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}


	
	
	

}
