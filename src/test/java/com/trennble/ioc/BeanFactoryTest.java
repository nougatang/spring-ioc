package com.trennble.ioc;

import com.trennble.ioc.factory.AutowireCapableBeanFactory;
import com.trennble.ioc.factory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {

	@Test
	public void test() {
		// 1.初始化beanfactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();

		// 2.bean定义
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("com.trennble.ioc.HelloWorldService");

		// 3.bean设置属性
		PropertyValue propertyValue=new PropertyValue("value","trennble");
		PropertyValues propertyValues=new PropertyValues();
		propertyValues.addPropertyValue(propertyValue);
		beanDefinition.setPropertyValues(propertyValues);

		// 4.注入bean
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 5.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }
}