package com.yee.study.activiti.component.task;

import java.util.List;

/**
 * Lnk服务调用器类。
 * 
 * @author sea.bao
 */
public interface LnkServiceCaller {
	/**
	 * 获得Lnk调用方法反射对象。
	 * 
	 * @param callDef
	 * @return
	 */
	ReflectedLnkServiceMethod getReflectedLnkServiceMethod(LnkServiceCallDefine callDef, int argsNo);

	/**
	 * 调用处理。
	 *
	 * @param callDef
	 * @param args
	 * @return
	 */
	Object call(LnkServiceCallDefine callDef, List<Object> args);
}