package com.trennble.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用一个类封装List是为了可以自定义额外的方法
 */
public class PropertyValues {

    private List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValues.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }
}
