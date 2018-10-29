package com.trennble.ioc.aop;

import com.trennble.ioc.HelloWorldService;
import com.trennble.ioc.HelloWorldServiceImpl;
import com.trennble.ioc.aop.proxy.Cglib2AopProxy;
import com.trennble.ioc.bean.context.ApplicationContext;
import com.trennble.ioc.bean.context.ClassPathXmlApplicationContext;
import org.junit.Test;

public class Cglib2AopProxyTest {

	@Test
	public void testInterceptor() throws Exception {
		// --------- helloWorldService without AOP
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();

		// --------- helloWorldService with AOP
		// 1. 设置被代理对象(Joinpoint)
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldServiceImpl.class,
				HelloWorldService.class);
		advisedSupport.setTargetSource(targetSource);

		// 2. 设置拦截器(Advice)
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(timerInterceptor);

		// 3. 创建代理(Proxy)
        Cglib2AopProxy cglib2AopProxy = new Cglib2AopProxy(advisedSupport);
		HelloWorldServiceImpl helloWorldServiceProxy = (HelloWorldServiceImpl) cglib2AopProxy.getProxy();

		// 4. 基于AOP的调用
		helloWorldServiceProxy.extra();

	}
}