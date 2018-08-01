package com.trennble.ioc.factory;

import com.trennble.ioc.BeanDefinition;

public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);

}