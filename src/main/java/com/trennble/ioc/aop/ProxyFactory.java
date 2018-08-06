package com.trennble.ioc.aop;

import com.trennble.ioc.aop.proxy.AopProxy;
import com.trennble.ioc.aop.proxy.Cglib2AopProxy;

public class ProxyFactory extends AdvisedSupport implements AopProxy {

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    protected final AopProxy createAopProxy() {
        return new Cglib2AopProxy(this);
    }
}