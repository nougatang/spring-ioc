package com.trennble.ioc.context;

import com.trennble.ioc.HelloWorldService;
import com.trennble.ioc.bean.context.ApplicationContext;
import com.trennble.ioc.bean.context.ClassPathXmlApplicationContext;
import org.junit.Test;

public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}