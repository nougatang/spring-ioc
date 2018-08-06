package com.trennble.ioc.aop;

/**
 * 被代理的对象
 */
public class TargetSource {

    private Object target;

    private Class<?>[] interfaces;

    private Class<?> targetClass;


    public TargetSource(Object target, Class<?> targetClass, Class<?>... interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    public Object getTarget() {
        return target;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }
}
