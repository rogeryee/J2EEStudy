package com.yee.study.activiti.component.task;

import org.activiti.engine.impl.bpmn.behavior.TaskActivityBehavior;
import org.activiti.engine.impl.el.FixedValue;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyServiceTask extends TaskActivityBehavior implements ApplicationContextAware
{
	private static final Logger logger = LoggerFactory.getLogger(MyServiceTask.class);

    /**
     * Spring Context
     */
    private ApplicationContext applicationContext;

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

        logger.info("className = " + className.getExpressionText());

        Class clazz = Class.forName(className.getExpressionText());
        Object object = applicationContext.getBean(clazz);

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

    public ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
    }
}
