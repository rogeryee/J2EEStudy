package com.yee.study.quartz.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: RogerYee
 * Create: 8/25/15
 */
public class SpringJobTest
{
    public static void main(String [] args)
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring-quartz-config.xml"},SpringJobTest.class);

    }
}
