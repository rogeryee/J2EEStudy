package com.yee.study.activiti.component;

import org.activiti.bpmn.model.ImplementationType;
import org.activiti.bpmn.model.ParallelGateway;
import org.activiti.bpmn.model.ServiceTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.impl.bpmn.behavior.ParallelGatewayActivityBehavior;
import org.activiti.engine.impl.bpmn.behavior.ServiceTaskDelegateExpressionActivityBehavior;
import org.activiti.engine.impl.bpmn.parser.factory.DefaultActivityBehaviorFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivityBehaviorFactory extends DefaultActivityBehaviorFactory
{
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 创建自定义任务行为
     *
     * @param serviceTask
     * @return
     */
    public ServiceTaskDelegateExpressionActivityBehavior createCustomServiceTaskBehavior(ServiceTask serviceTask)
    {
        Expression delegateExpression = null;
        if (ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION
                .equalsIgnoreCase(serviceTask.getImplementationType()))
        {
            logger.debug("using delegateExpression to set task [{}] behavior [{}]", serviceTask.getId(), serviceTask.getImplementation());
            delegateExpression = expressionManager.createExpression(serviceTask.getImplementation());
        }
        else
        {
            logger.debug("using fix spring task bean to set task [{}]", serviceTask.getId());
            delegateExpression = expressionManager.createExpression("${MyServiceTask}");
        }
        Expression skipExpression;
        if (StringUtils.isNotEmpty(serviceTask.getSkipExpression()))
        {
            skipExpression = expressionManager.createExpression(serviceTask.getSkipExpression());
        }
        else
        {
            skipExpression = null;
        }
        //设置
        return new ServiceTaskDelegateExpressionActivityBehavior(serviceTask.getId(), delegateExpression,
                skipExpression, createFieldDeclarations(serviceTask.getFieldExtensions()));
    }
}
