package com.pusong.study.aopTest.aspet;

import com.pusong.study.aopTest.annotation.LogAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspet {
    @Pointcut("@annotation(com.pusong.study.aopTest.annotation.LogAnnotation)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("log start...");
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        LogAnnotation logAnnotation = methodSignature.getMethod().getAnnotation(LogAnnotation.class);

        System.out.println("annotation code: " + logAnnotation.code());
        System.out.println("annotation description: " + logAnnotation.description());

        Object result = proceedingJoinPoint.proceed();
        System.out.println("log end.");

        return result;
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterthrowing(Throwable e) {
        System.out.println("log exception: " + e.getMessage());
    }
}
