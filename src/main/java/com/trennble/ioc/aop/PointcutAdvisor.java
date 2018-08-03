package com.trennble.ioc.aop;

public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();

}
