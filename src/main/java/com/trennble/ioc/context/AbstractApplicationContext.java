package com.trennble.ioc.context;

import com.trennble.ioc.factory.AbstractBeanFactory;
import com.trennble.ioc.factory.BeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() {
    }

    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }
}
