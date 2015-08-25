package com.yee.study.quartz.spring;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Author: RogerYee
 * Create: 8/25/15
 */
public class SpringJob2 extends QuartzJobBean
{
    static final Logger logger = LoggerFactory.getLogger(SpringJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
        logger.debug("SpringJob2 executed!");
    }
}
