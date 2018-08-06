package com.trennble.ioc.aop.advisor;

import com.trennble.ioc.aop.pointcut.AspectJExpressionPointcut;
import com.trennble.ioc.aop.pointcut.Pointcut;
import org.aopalliance.aop.Advice;

public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

    public Advice getAdvice() {
        return advice;
    }

    public Pointcut getPointcut() {
        return pointcut;
    }
}