package com.ashish.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("execution(* com.ashish.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toLongString();
		System.out.println("\n  ====>>>> Executing @around advice  on method: "+ method);
		
		long begin = System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		System.out.println("duration :: " + ((end-begin) /1000.0)+ "seconds");
		
		return result;
	}
	
	@After("execution(* com.ashish.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAccount(JoinPoint theJointPoint) {
		
		String method = theJointPoint.getSignature().toLongString();
		System.out.println("\n  ====>>>> Executing @after advice (finally) on method: "+ method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.ashish.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method = theJoinPoint.getSignature().toString();
		
		System.out.println("\n ===>>> Executing @afterthrowing on method :: " + method);
		
		System.out.println("\n ===>>> Executing @afterthrowing on method :: " + theExc);
		
	}
	
	
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
