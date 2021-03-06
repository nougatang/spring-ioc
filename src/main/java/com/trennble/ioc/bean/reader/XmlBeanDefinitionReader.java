package com.trennble.ioc.bean.reader;

import com.trennble.ioc.bean.BeanDefinition;
import com.trennble.ioc.bean.BeanReference;
import com.trennble.ioc.bean.PropertyValue;
import com.trennble.ioc.bean.io.Resource;
import com.trennble.ioc.bean.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    public void loadBeanDefinition(String location){
        Resource resource = getResourceLoader().getResource(location);
        try {
            InputStream inputStream = resource.getInputStream();
            doLoadBeanDefinition(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doLoadBeanDefinition(InputStream inputStream) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);

        registryBeanDefinition(document);
        inputStream.close();
    }

    private void registryBeanDefinition(Document document){
        Element root = document.getDocumentElement();

        parseBeanDefinition(root);
    }

    private void parseBeanDefinition(Element root){
        NodeList childNodes = root.getChildNodes();
        for (int i=0;i<childNodes.getLength();i++){
            Node node = childNodes.item(i);
            if (node instanceof Element){
                processBeanDefinition((Element)node);
            }
        }
    }

    private void processBeanDefinition(Element element){
        String name = element.getAttribute("id");
        String className = element.getAttribute("class");

        //生成bean definition
        BeanDefinition beanDefinition=new BeanDefinition();
        //设置bean属性
        processPropertyValue(beanDefinition,element);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name,beanDefinition);
    }

    private void processPropertyValue(BeanDefinition beanDefinition, Element element){
        NodeList propertys = element.getElementsByTagName("property");
        for (int i=0;i<propertys.getLength();i++){
            Node node = propertys.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    String ref = propertyEle.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '" + name + "' must specify a ref or value");
                    }

                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }
}
