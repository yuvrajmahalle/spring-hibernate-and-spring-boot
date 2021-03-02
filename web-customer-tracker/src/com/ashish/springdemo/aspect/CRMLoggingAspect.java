package com.ashish.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component 
public class CRMLoggingAspect {
	
	// setup logger
	private Logger myLogger = 
			Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.ashish.sprindemo.controller.*.*.(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.ashish.sprindemo.controller.*.*.(..))")
	private void forSerivcePackage() {}
	
	@Pointcut("execution(* com.ashish.sprindemo.controller.*.*.(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forSerivcePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// disp
	}
	
	// add @afterreturning advice

}
