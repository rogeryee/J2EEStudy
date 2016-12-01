package com.yee.study.activiti.custom;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.cmd.SignalCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: RogerYee
 * Create: 11/24/16
 */
public class WorkflowContext
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProcessEngineConfigurationImpl configuration;

    public void reSignal(final String executionId)
    {
        logger.info("start send signal to flow executionId [{}]", executionId);
        SignalCmd signalCmd = new SignalCmd(executionId, null, null, null);
        configuration.getCommandExecutor().execute(signalCmd);
    }
}
