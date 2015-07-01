package com.yee.study.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: RogerYee
 */
public class BeanWithRequiredAnnotationClient
{
    static Logger logger = LoggerFactory.getLogger(BeanWithRequiredAnnotation.class);

    public static void main(String [] args)
    {
        // 通过加载Classpath下的spring-ioc.xml
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"classpath:com/yee/study/spring/ioc/spring-ioc.xml"});

        // 测试使用了@Required注释的BeanWithRequiredAnnotation
        BeanWithRequiredAnnotation bean = context.getBean("beanWithRequiredAnnotation", BeanWithRequiredAnnotation.class);
        logger.debug(bean.getStringBean());
    }
}
