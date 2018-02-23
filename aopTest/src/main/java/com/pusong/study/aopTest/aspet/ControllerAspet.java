package com.pusong.study.aopTest.aspet;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Order(10000)
public class ControllerAspet {
    @Pointcut("execution(public * com.pusong.study.aopTest.controller..*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("class name: " + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("method name: " + joinPoint.getSignature().getName());

        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println(i + "/" + args.length + " parameter: " +argNames[i] + " = " + args[i]);
        }
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println("exception: " + e.getMessage());
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around...");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        System.out.println("elapsed time: " + stopWatch.getTotalTimeSeconds());

        return result;
    }
}
