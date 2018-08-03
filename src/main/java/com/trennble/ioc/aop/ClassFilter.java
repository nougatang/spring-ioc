package com.trennble.ioc.aop;

public interface ClassFilter {

    boolean matches(Class targetClass);
}
