package com.trennble.ioc.aop;

import com.trennble.ioc.factory.BeanFactory;

public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}