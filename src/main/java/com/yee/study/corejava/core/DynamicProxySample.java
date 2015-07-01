package com.yee.study.corejava.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 本例展示了如何使用JDK来实现动态代理
 * <p/>
 * User: RogerYee
 */
public class DynamicProxySample
{
    public static void main(String[] args)
    {
        IHello hello = new HelloImpl();
        HelloHandler handler = new HelloHandler(hello);

        IHello helloProxy = (IHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);

        helloProxy.hello();
    }
}

interface IHello
{
    public void hello();
}

class HelloImpl implements IHello
{
    @Override
    public void hello()
    {
        System.out.println("Hello World!");
    }
}

class HelloHandler implements InvocationHandler
{
    private Object obj;

    public HelloHandler(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        this.doBefore();

        Object result = method.invoke(this.obj, args);

        this.doAfter();

        return result;
    }

    private void doBefore()
    {
        System.out.println("doBefore...");
    }

    private void doAfter()
    {
        System.out.println("doAfter...");
    }
}
