package com.yee.study.utilites.timeout;

import java.lang.reflect.Proxy;

/**
 * Author: RogerYee
 */
public class Factory
{
    public static Object getObject(Class<?> clazz)
    {
        Object obj = null;

        TimeoutMethodHandler th =  new TimeoutMethodHandler();
        try
        {
            obj = Class.forName(clazz.getCanonicalName()).newInstance();
            th.setTarget(obj);
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return Proxy.newProxyInstance(
                TimeoutTest.class.getClassLoader(),
                TimeoutTest.class.getInterfaces(),
                th);
    }
}
