package com.yee.study.spring.ioc;

import org.springframework.beans.factory.annotation.Required;

/**
 * Author: RogerYee
 *
 * 用于测试@Required，在setStringProp()方法上添加了@Required;
 * 如果在相应的XML文件（spring-ioc.xml）中没有用setter的方式配置stringProp属性，则会抛出BeanInitializationException
 */
public class BeanWithRequiredAnnotation
{
    private String stringBean;

    public String getStringBean()
    {
        return stringBean;
    }

    @Required
    public void setStringBean(String stringBean)
    {
        this.stringBean = stringBean;
    }
}
