package com.yee.study.activiti.component;

import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.ServiceTask;
import org.activiti.validation.ValidationError;
import org.activiti.validation.validator.Problems;
import org.activiti.validation.validator.impl.ServiceTaskValidator;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class CustomServiceTaskValidator extends ServiceTaskValidator {

	@Override
	protected void verifyType(Process process, ServiceTask serviceTask, List<ValidationError> errors) {
		if (StringUtils.isNotEmpty(serviceTask.getType())) {
		  	
		    if (!serviceTask.getType().equalsIgnoreCase("mail")
		    		&& !serviceTask.getType().equalsIgnoreCase("mule")
		    		&& !serviceTask.getType().equalsIgnoreCase("camel")
		    		&& !serviceTask.getType().equalsIgnoreCase("shell")
		    		&& !serviceTask.getType().equalsIgnoreCase(ServiceTaskTypes.MY_TASK)
		    ) {
		    	addError(errors, Problems.SERVICE_TASK_INVALID_TYPE, process, serviceTask, "Invalid or unsupported service task type");
		    }
		    
		    if (serviceTask.getType().equalsIgnoreCase("mail")) {
		      validateFieldDeclarationsForEmail(process, serviceTask, serviceTask.getFieldExtensions(), errors);
		    } else if (serviceTask.getType().equalsIgnoreCase("shell")) {
		    	validateFieldDeclarationsForShell(process, serviceTask, serviceTask.getFieldExtensions(), errors);
		    }
		    
		  }
	}
}
