package com.yee.study.activiti.component.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Lnk服务调用定义类。
 */
public class LnkServiceCallDefine
{
	/**
	 * 服务组
	 */
	private String serviceGroup;

	/**
	 * 服务编号
	 */
	private String serviceId;

	/**
	 * 服务接口类
	 */
	private Class<?> serviceInterface;

	/**
	 * 方法
	 */
	private String methodName;

	/**
	 * 参数的dataPath或者固定数值$fix:...集
	 */
	private List<String> argPaths = new ArrayList<String>();

	/**
	 * 总是刷新数据，每次访问数据都先调用lnk。
	 */
	private boolean alwaysRefreshData = false;

	/**
	 * 是否应用异常作为数据存储，一旦发生异常数据桶路径下将自动生成{ "_bizEx": {"code": ..., "message": ...}}
	 */
	private boolean appBizExceptionAsData = false;

	public String getMethodSignature() {
		StringBuffer sb = new StringBuffer();
		sb.append(serviceInterface.getName());
		sb.append(".");
		sb.append(methodName);
		sb.append("/");
		sb.append(argPaths == null ? 0 : argPaths.size());
		
		return sb.toString();
	}

	public String getServiceGroup() {
		return serviceGroup;
	}

	public void setServiceGroup(String serviceGroup) {
		this.serviceGroup = serviceGroup;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Class<?> getServiceInterface() {
		return serviceInterface;
	}

	public void setServiceInterface(Class<?> serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public List<String> getArgPaths() {
		return argPaths;
	}

	public void setArgPaths(List<String> argPaths) {
		this.argPaths = argPaths;
	}

	public boolean isAppBizExceptionAsData() {
		return appBizExceptionAsData;
	}

	public void setAppBizExceptionAsData(boolean supportAppBizException) {
		this.appBizExceptionAsData = supportAppBizException;
	}

	public boolean isAlwaysRefreshData() {
		return alwaysRefreshData;
	}

	public void setAlwaysRefreshData(boolean alwaysRefreshData) {
		this.alwaysRefreshData = alwaysRefreshData;
	}
}
