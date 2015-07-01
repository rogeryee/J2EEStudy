package com.yee.study.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: RogerYee
 *
 * 该类的构造器被标示了@Autowired，那么当Spring初始化该Bean的时候，会自动匹配合适的Bean注入。
 */
public class BeanWithAutowiredAnnotation
{
    static Logger logger = LoggerFactory.getLogger(BeanWithAutowiredAnnotation.class);

    private String stringBean;

    @Autowired
    public BeanWithAutowiredAnnotation(String stringBean)
    {
        logger.debug("Constructor() is invoked.");
        this.stringBean = stringBean;
    }

    public String getStringBean()
    {
        return stringBean;
    }

    @Autowired
    public void setStringBean(String stringBean)
    {
        logger.debug("Setter is invoked.");
        this.stringBean = stringBean;
    }
}
