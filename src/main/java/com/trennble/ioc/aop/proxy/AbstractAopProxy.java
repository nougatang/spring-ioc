package com.trennble.ioc.aop.proxy;

import com.trennble.ioc.aop.AdvisedSupport;

public abstract class AbstractAopProxy implements AopProxy {

    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}