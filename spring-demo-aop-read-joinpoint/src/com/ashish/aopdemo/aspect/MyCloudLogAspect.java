package com.ashish.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {
	@Before("com.ashish.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloud() {
		System.out.println("\n=====>>> Executing logToCloud advice on method");
		
	}
	
}
