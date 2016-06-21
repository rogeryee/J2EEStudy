package com.yee.study.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: RogerYee
 * <p/>
 * 调用src/sample-beans.xml生成对象
 */
public class CustomBeanDefinitionClient
{
    public static void main(String[] args)
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring-bean.xml"}, CustomBeanDefinitionClient.class);

        // 1. TestBeanWithCutomTag
        TestBeanWithCutomTag testBean = (TestBeanWithCutomTag)context.getBean("testCustom");
        System.out.println(testBean.getName());
    }
}
