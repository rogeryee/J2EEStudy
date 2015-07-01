package com.yee.study.utilites.timeout;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * Author: RogerYee
 * <p/>
 * 本类实现了Callable接口，在call方法被调用时会执行相应的Method.invoke方法a
 */
public class MethodCallable implements Callable
{
    private Object target;
    private Method method;
    private Object[] args;

    public Object getTarget()
    {
        return target;
    }

    public void setTarget(Object target)
    {
        this.target = target;
    }

    public Method getMethod()
    {
        return method;
    }

    public void setMethod(Method method)
    {
        this.method = method;
    }

    public Object[] getArgs()
    {
        return args;
    }

    public void setArgs(Object[] args)
    {
        this.args = args;
    }

    @Override
    public Object call() throws Exception
    {
        return method.invoke(this.target, args);
    }
}
