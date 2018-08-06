package com.trennble.ioc.aop.pointcut;

public interface ClassFilter {

    boolean matches(Class targetClass);
}
