package com.trennble.ioc.factory;

import com.trennble.ioc.BeanDefinition;
import com.trennble.ioc.BeanReference;
import com.trennble.ioc.PropertyValue;
import com.trennble.ioc.aop.BeanFactoryAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
        List<PropertyValue> propertyValues = beanDefinition.getPropertyValues().getPropertyValues();
        for (PropertyValue propertyValue : propertyValues) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference reference = (BeanReference) value;
                value = getBean(reference.getName());
            }

            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + propertyValue.getName().substring(0, 1).toUpperCase()
                                + propertyValue.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);

                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }
}
