package com.yee.study.activiti.component.task;

import org.activiti.engine.impl.bpmn.behavior.TaskActivityBehavior;
import org.activiti.engine.impl.el.FixedValue;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyServiceTask extends TaskActivityBehavior
{

	private static final Logger logger = LoggerFactory.getLogger(MyServiceTask.class);

    /**
     * 服务接口类
     */
    private FixedValue className;

	@Override
	public void signal(ActivityExecution execution, String signalName, Object signalData) throws Exception
    {
		logger.debug("receive data prepared signal executionId [{}] businessKey [{}] signalName [{}] signalData [{}]",
				execution.getId(), execution.getProcessBusinessKey(), signalName, signalData);
		execute(execution);
	}

	@Override
	public void execute(final ActivityExecution execution) throws Exception
    {
        logger.info("Enter execution : id = " + execution.getId() + ", instId = " + execution.getProcessInstanceId());

        leave(execution);
		logger.info("MyServiceTask executed.");
	}

    // Getters and Setters
    public FixedValue getClassName()
    {
        return className;
    }

    public void setClassName(FixedValue className)
    {
        this.className = className;
    }
}
