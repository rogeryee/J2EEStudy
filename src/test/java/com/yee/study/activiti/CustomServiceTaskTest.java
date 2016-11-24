package com.yee.study.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Author: RogerYee
 * Create: 11/9/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:activiti/spring-config.xml")
public class CustomServiceTaskTest
{
    private static final Logger logger = LoggerFactory.getLogger(CustomServiceTaskTest.class);

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Test
    public void testCustomTask()
    {
        // 部署流程定义
//        repositoryService.createDeployment().addClasspathResource("activiti/bpmn/customTask.bpmn20.xml").deploy();

        // 启动流程实例
        String procId = runtimeService.startProcessInstanceByKey("customizedTask").getId();
        logger.info("Process instance Id: " + procId);
    }
}
