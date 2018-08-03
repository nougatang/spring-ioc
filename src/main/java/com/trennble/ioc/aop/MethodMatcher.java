package com.trennble.ioc.aop;

import java.lang.reflect.Method;

public interface MethodMatcher {

    boolean matches(Class targetClass, Method method);
}
