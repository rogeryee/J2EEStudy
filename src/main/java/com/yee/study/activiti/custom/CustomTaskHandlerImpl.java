package com.yee.study.activiti.custom;

import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: RogerYee
 * Create: 11/24/16
 */
public class CustomTaskHandlerImpl implements CustomTaskHandler
{
    private static final Logger logger = LoggerFactory.getLogger(CustomTaskHandlerImpl.class);

    @Autowired
    private MockService mockService;

    @Autowired
    private WorkflowContext context;

    @Override
    public void doExecute(final ActivityExecution execution) throws Exception
    {
        logger.info("do execution");
        logger.info("variable = " + execution.getVariable("myTaskKey"));

        final String executionId = execution.getId();
        mockService.doSomething("ID", new MockServiceCallback()
        {
            @Override
            public void doCallback()
            {
                logger.info("In callback and executionId = {}", executionId);
                context.reSignal(executionId);
            }
        });
    }

    @Override
    public void doResume(ActivityExecution execution)
    {
        logger.info("do resume");
    }
}
