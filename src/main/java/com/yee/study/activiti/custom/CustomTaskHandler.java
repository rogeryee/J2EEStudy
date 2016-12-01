package com.yee.study.activiti.custom;

import org.activiti.engine.impl.pvm.delegate.ActivityExecution;

/**
 * Author: RogerYee
 * Create: 11/24/16
 */
public interface CustomTaskHandler
{
    void doExecute(ActivityExecution execution) throws Exception;

    void doResume(ActivityExecution execution);
}
