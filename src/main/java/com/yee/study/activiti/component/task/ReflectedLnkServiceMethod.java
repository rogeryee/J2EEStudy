package com.yee.study.activiti.component.task;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 反射的Lnk服务方法类。
 */
public class ReflectedLnkServiceMethod
{
	/**
	 * 方法
	 */
	private Method targetMethod;

	/**
	 * 参数类型集
	 */
	private List<Type> argTypes;

	public Method getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(Method targetMethod) {
		this.targetMethod = targetMethod;
	}

	public List<Type> getArgTypes() {
		return argTypes;
	}

	public void setArgTypes(List<Type> argTypes) {
		this.argTypes = argTypes;
	}
}
