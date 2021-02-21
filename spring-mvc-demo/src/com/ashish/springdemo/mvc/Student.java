package com.ashish.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	
	private String country;
	
	private LinkedHashMap<String, String> countryOptions;
	
	private String favoriteLanguage;
	
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("IN","India");
		countryOptions.put("IND","Indo");
		countryOptions.put("US","USA");
		countryOptions.put("BR","Brazil");
		countryOptions.put("AUS","AUS");
		
		
		favoriteLanguageOptions = new LinkedHashMap<>();
		
		favoriteLanguageOptions.put("JAVA","JAVA");
		favoriteLanguageOptions.put("PHP","PHP");
		favoriteLanguageOptions.put("CPP","CPP");
		favoriteLanguageOptions.put("PY","PY");
		  
		
	}

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	
	
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}
	
	 
	
}
