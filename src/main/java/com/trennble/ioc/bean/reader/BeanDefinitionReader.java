package com.trennble.ioc.bean.reader;

public interface BeanDefinitionReader {

    void loadBeanDefinition(String location) throws Exception;
}
