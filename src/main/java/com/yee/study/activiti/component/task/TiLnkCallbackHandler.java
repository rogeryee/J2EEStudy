package com.yee.study.activiti.component.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: RogerYee
 * Create: 11/17/16
 */
public class TiLnkCallbackHandler implements InvocationHandler
{
    private static final Logger logger = LoggerFactory.getLogger(TiLnkCallbackHandler.class);

    private Object obj;

    private String token;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        logger.info("##### before invoke and token = " + this.token);
        Object result = method.invoke(this.obj, args);
        logger.info("##### after invoke and token = " + this.token);
        return obj;
    }

    public Object getObj()
    {
        return obj;
    }

    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }
}
