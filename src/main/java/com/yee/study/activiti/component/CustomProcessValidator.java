package com.yee.study.activiti.component;

import org.activiti.validation.ProcessValidator;
import org.activiti.validation.ProcessValidatorImpl;
import org.activiti.validation.validator.ValidatorSet;
import org.activiti.validation.validator.ValidatorSetFactory;
import org.activiti.validation.validator.impl.ServiceTaskValidator;

public class CustomProcessValidator extends ProcessValidatorImpl implements ProcessValidator {
	public CustomProcessValidator() {
		ValidatorSet defaultValidatorSet = new ValidatorSetFactory().createActivitiExecutableProcessValidatorSet();
		defaultValidatorSet.removeValidator(ServiceTaskValidator.class);
		defaultValidatorSet.addValidator(new CustomServiceTaskValidator());
		addValidatorSet(defaultValidatorSet);
	}
}
