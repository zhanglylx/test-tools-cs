package com.tools.group.testtoolscs.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/9 10:45
 */
@Aspect
//@Component
public class FontAspect {

    @Pointcut("execution(* com.tools.group.testtoolscs.main.GG.init())")
    public void methods(){}

    @Before("methods()")
    public void before(){
        System.out.println("=======================sdfsdfadsfsf");
    }
}
