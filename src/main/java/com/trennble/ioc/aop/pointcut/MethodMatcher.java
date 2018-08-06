package com.trennble.ioc.aop.pointcut;

import java.lang.reflect.Method;

public interface MethodMatcher {

    boolean matches(Class targetClass, Method method);
}
