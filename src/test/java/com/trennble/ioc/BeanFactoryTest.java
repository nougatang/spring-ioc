package com.trennble.ioc;

import com.trennble.ioc.factory.AbstractBeanFactory;
import com.trennble.ioc.factory.AutowireCapableBeanFactory;
import com.trennble.ioc.io.ResourceLoader;
import com.trennble.ioc.reader.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 1.初始化beanfactory
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.指定配置文件
        ResourceLoader resourceLoader = new ResourceLoader();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(resourceLoader);
        xmlBeanDefinitionReader.loadBeanDefinition("application.xml");
        Map<String, BeanDefinition> registrys = xmlBeanDefinitionReader.getRegistry();

        for (Map.Entry<String, BeanDefinition> entry : registrys.entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

        // 5.获取bean
        HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }

    @Test
    public void reference() throws Exception {
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("application.xml");

        for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

        beanFactory.preInstantiateSingletons();
        OutputService outerService = (OutputService) beanFactory.getBean("outputService");
        outerService.output("test");
    }
}