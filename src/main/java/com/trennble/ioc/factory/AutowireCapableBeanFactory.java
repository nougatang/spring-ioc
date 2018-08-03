package com.trennble.ioc.factory;

import com.trennble.ioc.BeanDefinition;
import com.trennble.ioc.BeanReference;
import com.trennble.ioc.PropertyValue;

import java.lang.reflect.Field;
import java.util.List;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {


    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        List<PropertyValue> propertyValues = beanDefinition.getPropertyValues().getPropertyValues();
        for (PropertyValue propertyValue : propertyValues) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference reference = (BeanReference) value;
                value = getBean(reference.getName());
            }
            declaredField.set(bean, value);
        }
    }
}
