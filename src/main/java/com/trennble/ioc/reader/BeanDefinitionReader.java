package com.trennble.ioc.reader;

public interface BeanDefinitionReader {

    void loadBeanDefinition(String location) throws Exception;
}
