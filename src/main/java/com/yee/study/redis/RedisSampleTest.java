package com.yee.study.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: RogerYee
 */
public class RedisSampleTest
{
    public static void main(String [] args)
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring-redis-config.xml"}, RedisSampleTest.class);

        // 1. 用SampleBean的默认构造器来生成SampleBean
        RedisSample sample = context.getBean("redisSample", RedisSample.class);
        sample.getStringFromRedis();
    }
}
