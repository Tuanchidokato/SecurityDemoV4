package com.example.SecurityDemoV4.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AuthenticationAspect {
    private Logger  logger = LoggerFactory.getLogger(AuthenticationAspect.class);

    @Before("execution(* com.example.SecurityDemoV4.Controller.AuthController.authenticateUser(..)")
    public void before(JoinPoint joinPoint){
        logger.info(" before called "+ "loginRequest.getUsername()" + joinPoint.toString());
    }
}
