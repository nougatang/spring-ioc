package com.trennble.ioc.factory;

import com.trennble.ioc.BeanDefinition;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
