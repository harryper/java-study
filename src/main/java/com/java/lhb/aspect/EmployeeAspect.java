package com.java.lhb.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author harryper
 * @date 2020/8/20
 *
 */
@Aspect
public class EmployeeAspect {

    @Pointcut("execution(* com.java.lhb.aspect.Employee.work(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before() {
        System.out.println("上班之前打卡...");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("下班之前打开...");
    }
}
