package com.trennble.ioc.factory;

import com.trennble.ioc.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private List<String> beanDefinitionNames = new ArrayList<String>();

    public Object getBean(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        } else {
            Object bean = beanDefinition.getBean();
            if (bean == null) {
                bean = this.doCreateBean(beanDefinition);
            }
            return bean;
        }
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionNames.add(name);
        beanDefinitionMap.put(name, beanDefinition);
    }

    public void preInstantiateSingletons() {
        for (String name : beanDefinitionNames) {
            getBean(name);
        }
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition);
}
