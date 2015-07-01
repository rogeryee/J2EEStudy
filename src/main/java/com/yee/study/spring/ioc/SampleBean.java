package com.yee.study.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: RogerYee
 */
public class SampleBean
{
    static Logger logger = LoggerFactory.getLogger(SampleBean.class);

    public void sayHello()
    {
        logger.debug(this.toString() + ":Say Hello!");
    }
}
