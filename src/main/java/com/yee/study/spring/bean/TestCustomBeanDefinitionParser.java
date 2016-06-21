package com.yee.study.spring.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Author: RogerYee
 * Create: 2/19/16
 */
public class TestCustomBeanDefinitionParser implements BeanDefinitionParser
{
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        String id = element.getAttribute("id");
        String name = element.getAttribute("name");

        RootBeanDefinition beanDefinition = new RootBeanDefinition(TestBeanWithCutomTag.class);
        beanDefinition.getPropertyValues().addPropertyValue("name", name);
        parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);

        return beanDefinition;
    }
}
