package com.trennble.ioc.aop.advisor;

import com.trennble.ioc.aop.pointcut.Pointcut;

public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();

}
