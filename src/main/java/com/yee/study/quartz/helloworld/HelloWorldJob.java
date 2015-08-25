package com.yee.study.quartz.helloworld;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: RogerYee
 * Create: 8/25/15
 */
public class HelloWorldJob implements Job
{
    static final Logger logger = LoggerFactory.getLogger(HelloWorldJob.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        logger.debug("HelloWorldJob executed!");
    }
}
