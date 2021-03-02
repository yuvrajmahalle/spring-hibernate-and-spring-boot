package com.ashish.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

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
	
	private Logger myLogger = 
			Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.ashish.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toLongString();
		myLogger.info("\n  ====>>>> Executing @around advice  on method: "+ method);
		
		long begin = System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		myLogger.info("duration :: " + ((end-begin) /1000.0)+ "seconds");
		
		return result;
	}
	
	@After("execution(* com.ashish.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAccount(JoinPoint theJointPoint) {
		
		String method = theJointPoint.getSignature().toLongString();
		myLogger.info("\n  ====>>>> Executing @after advice (finally) on method: "+ method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.ashish.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method = theJoinPoint.getSignature().toString();
		
		myLogger.info("\n ===>>> Executing @afterthrowing on method :: " + method);
		
		myLogger.info("\n ===>>> Executing @afterthrowing on method :: " + theExc);
		
	}
	
	
	@AfterReturning(
			pointcut="execution(* com.ashish.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		 	
		String method = theJoinPoint.getSignature().toString();
		
		myLogger.info("\n ===>>> Executing afterReturning on method :: " + method);
		
		myLogger.info("result ===>>> " + result);
		
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("result ===>>> " + result);
		
	}
	
	 
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for(Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
		}
	}


	@Before("com.ashish.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n=====>>> Executing @Before advice on method");
		
		// display the method signature 
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method : " + methodSig);
		
		// display method arguments
		
		Object[] args = theJoinPoint.getArgs();
		
		// get data using joinpoints
		for(Object tempArg : args) {
			
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name : "+ theAccount.getName());
				myLogger.info("account name : "+ theAccount.getLevel());
			}
			
		}
		
	}
	 
}
