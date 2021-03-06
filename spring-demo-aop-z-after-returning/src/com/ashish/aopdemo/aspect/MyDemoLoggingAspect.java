package com.ashish.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ashish.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	
	@AfterReturning(
			pointcut="execution(* com.ashish.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		 	
		String method = theJoinPoint.getSignature().toString();
		
		System.out.println("\n ===>>> Executing afterReturning on method :: " + method);
		
		System.out.println("result ===>>> " + result);
		
		convertAccountNamesToUpperCase(result);
		
		System.out.println("result ===>>> " + result);
		
	}
	
	 
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for(Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
		}
	}


	@Before("com.ashish.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on method");
		
		// display the method signature 
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method : " + methodSig);
		
		// display method arguments
		
		Object[] args = theJoinPoint.getArgs();
		
		// get data using joinpoints
		for(Object tempArg : args) {
			
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name : "+ theAccount.getName());
				System.out.println("account name : "+ theAccount.getLevel());
			}
			
		}
		
	}
	 
}
