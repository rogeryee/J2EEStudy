package com.yee.study.quartz.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: RogerYee
 * Create: 8/25/15
 */
public class SpringJob
{
    static final Logger logger = LoggerFactory.getLogger(SpringJob.class);

    public void run()
    {
        logger.debug("SpringJob executed!");
    }
}
