package com.example.demo.controller;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;
//import com.example.demo.controller.Library.
@Controller
@Aspect
public class LoggingAspect {
	// pointcut
	@Before("execution(* com.example.demo.controller.Library.donateBook(..))")	
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println("Logging Aspect triggered for method: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: " + java.util.Arrays.toString(joinPoint.getArgs()));

	}

}
