package com.yee.study.utilites.timeout;

import java.lang.reflect.Method;

/**
 * User: RogerYee
 * <p/>
 * 记录标记了@Timeout的方法以及其所属类对象
 */
public class TimeoutMethod
{
    private Timeout timeout;
    private Object object;
    private Method method;

    public TimeoutMethod()
    {
    }

    public Timeout getTimeout()
    {
        return timeout;
    }

    public void setTimeout(Timeout timeout)
    {
        this.timeout = timeout;
    }

    public Object getObject()
    {
        return object;
    }

    public void setObject(Object object)
    {
        this.object = object;
    }

    public Method getMethod()
    {
        return method;
    }

    public void setMethod(Method method)
    {
        this.method = method;
    }
}
