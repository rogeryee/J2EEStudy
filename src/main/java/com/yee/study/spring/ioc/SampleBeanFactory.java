package com.yee.study.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: RogerYee
 */
public class SampleBeanFactory
{
    static Logger logger = LoggerFactory.getLogger(SampleBeanFactory.class);

    public static SampleBean createSampleBean()
    {
        SampleBean ret = new SampleBean();

        logger.debug("createSampleBean() is invoked and bean = " + ret.toString());

        return ret;
    }

    public SampleBean createSampleBeanInstance()
    {
        SampleBean ret = new SampleBean();

        logger.debug("createSampleBeanInstance() is invoked and bean = " + ret.toString());

        return ret;
    }
}
