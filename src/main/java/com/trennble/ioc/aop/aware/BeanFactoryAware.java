package com.trennble.ioc.aop.aware;

import com.trennble.ioc.bean.factory.BeanFactory;

public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}