package com.trennble.ioc.aop;

/**
 * 被代理的对象
 */
public class TargetSource {

    private Object target;

    private Class targetClass;

    public TargetSource(Object target, Class targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public Class getTargetClass() {
        return targetClass;
    }
}
