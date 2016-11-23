package com.yee.study.activiti.component.task;

import me.andpay.ti.base.AppBizException;
import me.andpay.ti.lnk.api.RemoteObjectFactory;
import me.andpay.ti.lnk.api.RemoteObjectFactoryAware;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Lnk服务调用器类。
 */
public class LnkServiceCallerImpl implements RemoteObjectFactoryAware, LnkServiceCaller
{
    /**
     * 远程对象工厂
     */
    private RemoteObjectFactory remoteObjectFactory;

    /*
     * (non-Javadoc)
     *
     * @see
     * me.andpay.ac.lrds.srv.rds.LnkServiceCaller#call(me.andpay.ac.lrds.srv.db.
     * LnkServiceCallDefine, java.util.List)
     */
    @Override
    public Object call(LnkServiceCallDefine callDef, List<Object> args)
    {
        Object remoteObj;
        if (callDef.getServiceId() != null && callDef.getServiceGroup() != null)
        {
            remoteObj = remoteObjectFactory.getRemoteObject(callDef.getServiceInterface(), callDef.getServiceId(),
                    callDef.getServiceGroup());
        }
        else
        {
            remoteObj = remoteObjectFactory.getRemoteObject(callDef.getServiceInterface());
        }

        int argsNo = args == null? 0 : args.size();
        Method targetMethod = getReflectedLnkServiceMethod(callDef, argsNo).getTargetMethod();

        Object retValue = null;
        AppBizException appEx = null;

        try
        {
            retValue = targetMethod.invoke(remoteObj, args.toArray());
        }
        catch (IllegalAccessException e)
        {
            throw new RuntimeException(e.getMessage(), e);
        }
        catch (InvocationTargetException e)
        {
            if (e.getCause() != null)
            {
                if (e.getCause() instanceof RuntimeException)
                {
                    throw (RuntimeException) e.getCause();
                }
                else if (callDef.isAppBizExceptionAsData() && e.getCause() instanceof AppBizException)
                {
                    appEx = (AppBizException) e.getCause();
                    Map<String, Object> retMap = new TreeMap<String, Object>();
                    Map<String, String> bizExMap = new TreeMap<String, String>();
                    bizExMap.put("code", appEx.getCode());
                    bizExMap.put("message", appEx.getMessage());
                    retMap.put("_bizEx", bizExMap);

                    return retMap;
                }
                else
                {
                    throw new RuntimeException(e.getCause().getMessage(), e.getCause());
                }
            }
            else
            {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        return retValue;
    }

    @Override
    public ReflectedLnkServiceMethod getReflectedLnkServiceMethod(LnkServiceCallDefine callDef, int argsNo)
    {
        ReflectedLnkServiceMethod rlsm = new ReflectedLnkServiceMethod();

        Method[] methods = callDef.getServiceInterface().getDeclaredMethods();
        Method targetMethod = null;
        for (Method method : methods)
        {
            if (method.getName().equals(callDef.getMethodName())
                    && method.getParameterTypes().length == argsNo)
            {
                targetMethod = method;
            }
        }

        if (targetMethod == null)
        {
            throw new RuntimeException("Not found the method, methodName=[" + callDef.getMethodName()
                    + "], argsCount=[" + callDef.getArgPaths().size() + "].");
        }

        rlsm.setTargetMethod(targetMethod);
        List<Type> argTypes = new ArrayList<Type>();
        for (Type paraType : targetMethod.getGenericParameterTypes())
        {
            argTypes.add(paraType);
        }

        rlsm.setArgTypes(argTypes);

        return rlsm;
    }

    @Override
    public void setRemoteObjectFactory(RemoteObjectFactory factory)
    {
        this.remoteObjectFactory = factory;
    }

}
