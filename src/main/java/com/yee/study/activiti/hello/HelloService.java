package com.yee.study.activiti.hello;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: RogerYee
 * Create: 11/9/16
 */
public class HelloService implements JavaDelegate
{
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception
    {
        logger.info("Hello Service " + this.toString() + "Is Saying Hello To Every One !");
    }
}
