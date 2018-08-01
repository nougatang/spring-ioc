package com.trennble.ioc;

import com.trennble.ioc.factory.AutowireCapableBeanFactory;
import com.trennble.ioc.factory.BeanFactory;
import com.trennble.ioc.io.ResourceLoader;
import com.trennble.ioc.reader.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {

	@Test
	public void test() {
		// 1.初始化beanfactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();

		// 2.指定配置文件
		ResourceLoader resourceLoader=new ResourceLoader();
		XmlBeanDefinitionReader xmlBeanDefinitionReader=new XmlBeanDefinitionReader(resourceLoader);
		xmlBeanDefinitionReader.loadBeanDefinition("application.xml");
		Map<String, BeanDefinition> registrys = xmlBeanDefinitionReader.getRegistry();

		for (Map.Entry<String,BeanDefinition> entry:registrys.entrySet()){
			beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
		}

        // 5.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }
}