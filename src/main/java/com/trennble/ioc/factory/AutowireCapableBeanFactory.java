package com.trennble.ioc.factory;

import com.trennble.ioc.BeanDefinition;
import com.trennble.ioc.PropertyValue;

import java.lang.reflect.Field;
import java.util.List;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Object bean = createBeanInstance(beanDefinition);
            applyPropertyValues(bean, beanDefinition);
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        List<PropertyValue> propertyValues = beanDefinition.getPropertyValues().getPropertyValues();
        for (PropertyValue propertyValue : propertyValues) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }
}
