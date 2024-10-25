package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingIn {
	
	@Pointcut(value="execution(* com.example.demo.service.*.*(..))")
    public void loging() {}
	
	@Around(value="loging()")
	public Object aroundGreet(ProceedingJoinPoint jp) throws Throwable
	{
		Logger log=LoggerFactory.getLogger(LoggingIn.class);
		String methodName=jp.getSignature().getName();
		String className=jp.getTarget().getClass().toString();
		Object[] argms=jp.getArgs();
		ObjectMapper om=new ObjectMapper();
		
		
		log.info("inside "+className+" class "+"Method Name"+methodName+om.writeValueAsString(argms));
		Object res=jp.proceed();
		log.info("inside "+className+" class "+"Method Name"+methodName+om.writeValueAsString(argms)+om.writeValueAsString(res));
		
		return res;
	}

}
