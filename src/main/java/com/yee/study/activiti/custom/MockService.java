package com.yee.study.activiti.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: RogerYee
 * Create: 11/24/16
 */
public class MockService
{
    private static final Logger logger = LoggerFactory.getLogger(MockService.class);

    /**
     * @param id
     * @param callback
     */
    public void doSomething(String id, MockServiceCallback callback) throws Exception
    {
        logger.info("do something for id = " + id);

        Thread.sleep(3000L);
        if (callback != null)
        {
            callback.doCallback();
        }
    }
}
