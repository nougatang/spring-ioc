package com.trennble.ioc.context;

import com.trennble.ioc.HelloWorldServiceImpl;
import org.junit.Test;

public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}