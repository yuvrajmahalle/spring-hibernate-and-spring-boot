package com.ashish.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// pointcut declaration 
	@Pointcut("execution(* add*(com.ashish.aopdemo.Account))")
	private void forDaoPakage() {}

	@Before("forDaoPakage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPakage()")
	public void performApiAnalytics() {
		System.out.println("\n ====>>> Performing API");
	}
	
}
