package com.trennble.ioc.bean.reader;

import com.trennble.ioc.bean.BeanDefinition;
import com.trennble.ioc.bean.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private ResourceLoader resourceLoader;

    private Map<String,BeanDefinition> registry;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.registry = new HashMap<String, BeanDefinition>();
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }
}
