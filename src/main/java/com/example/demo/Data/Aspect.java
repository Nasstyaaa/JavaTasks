package com.example.demo.Data;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Slf4j
@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    @Around("execution(* com.example.demo.Service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("Execution time: {} ms", executionTime);
        return proceed;
    }
}
