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
 * 流程管理测试
 *
 * Author: RogerYee
 * Create: 11/9/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:activiti/spring-config.xml")
public class WorkflowAdminTest
{
    private static final Logger logger = LoggerFactory.getLogger(WorkflowAdminTest.class);

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    /**
     * 删除已发布的流程
     */
    @Test
    public void testDeleteDeployment()
    {
        repositoryService.deleteDeployment("272501", true);
    }

    /**
     * 删除任务
     */
    @Test
    public void testDeleteExecution()
    {
        runtimeService.deleteProcessInstance("272504", "Rollback");
    }
}
