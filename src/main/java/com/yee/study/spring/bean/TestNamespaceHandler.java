package com.yee.study.spring.bean;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Author: RogerYee
 * Create: 2/19/16
 */
public class TestNamespaceHandler extends NamespaceHandlerSupport
{
    public void init()
    {
        registerBeanDefinitionParser("custom", new TestCustomBeanDefinitionParser());
    }
}
