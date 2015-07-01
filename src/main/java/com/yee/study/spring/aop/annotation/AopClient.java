package com.yee.study.spring.aop.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: RogerYee
 *
 * 初始化AopConfig，并完成SpringIOC容器的初始化；
 * 完成AOP的操作
 */
public class AopClient
{
    static Logger logger = LoggerFactory.getLogger(AopClient.class);

    public static void main(String [] args) throws Exception
    {
        // 加载使用了@Configuration和@Component注释的Bean
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        SampleBean bean = context.getBean(SampleBean.class);
        bean.sayHello();
        logger.debug("----------------------");

        bean.sayHello("Roger", "Yee", 33, 34);
        logger.debug("----------------------");

        bean.sayHelloToYou();
        logger.debug("----------------------");

        bean.sayHi();
        logger.debug("----------------------");
    }
}
