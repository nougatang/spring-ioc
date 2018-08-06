package com.trennble.ioc.aop;

import com.trennble.ioc.HelloWorldService;
import com.trennble.ioc.HelloWorldServiceImpl;
import com.trennble.ioc.aop.pointcut.AspectJExpressionPointcut;
import org.junit.Assert;
import org.junit.Test;

public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.trennble.ioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.trennble.ioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImpl.class, HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"));
        Assert.assertTrue(matches);
    }
}