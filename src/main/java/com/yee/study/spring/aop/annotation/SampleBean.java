package com.yee.study.spring.aop.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Author: RogerYee
 * <p/>
 * 采用Annotation的方式声明Bean
 */
@Component
public class SampleBean
{
    static Logger logger = LoggerFactory.getLogger(SampleBean.class);

    public void sayHello()
    {
        logger.debug("sayHello");
    }

    public void sayHello(String firstName, String lastName, int age1, int age2)
    {
        logger.debug("sayHello : firstName = " + firstName + ", lastName = " + lastName + ", age1 = " + age1 + ", age2 = " + age2);
    }

    public String sayHelloToYou()
    {
        logger.debug("sayHelloToYou");
        return "sayHelloToYou";
    }

    public void sayHi() throws Exception
    {
        logger.debug("sayHi");

        // 如果需要测试SampleAspect中的@AfterThrowing，需要放开下面的语句
        //throw new IllegalArgumentException("Not valid argument.");
    }
}
