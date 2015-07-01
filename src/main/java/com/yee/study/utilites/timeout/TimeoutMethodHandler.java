package com.yee.study.utilites.timeout;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.*;

/**
 * Author: RogerYee
 */
public class TimeoutMethodHandler implements InvocationHandler
{
    private Object target;

    public Object getTarget()
    {
        return target;
    }

    public void setTarget(Object target)
    {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        TimeoutMethod timeoutMethod = this.getTimeoutMethod(method);

        // 如果是没有@Timeout注释的方法，则直接调用Method.invoke()
        if (timeoutMethod == null)
        {
            System.out.println(method.getName() + " execute without @Timeout");
            return method.invoke(this.target, args);
        }
        // 如果是标识了@Timeout的方法，则调用execute来执行
        else
        {
            System.out.println(timeoutMethod.getMethod().getName() + " execute with @Timeout");
            return this.execute(this.target, args, timeoutMethod);
        }
    }

    /**
     *
     * @param target
     * @param args
     * @param timeoutMethod
     * @return
     * @throws Throwable
     */
    private Object execute(Object target, Object[] args, TimeoutMethod timeoutMethod)
            throws Throwable
    {
        // 生成一个可以运行Method的Callable对象，并注入相应属性
        MethodCallable tc = new MethodCallable();
        tc.setMethod(timeoutMethod.getMethod());
        tc.setArgs(args);
        tc.setTarget(target);

        // 创建一个线程池来运行这个Callable对象
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<Object> future = new FutureTask<Object>(tc);
        executor.execute(new FutureTask<Object>(tc));

        Object ret = null;
        try
        {
            // 设置在“timeoutMethod.getTimeout().value()”后，获取future执行的返回值。
            // 这样达到了检测方法执行是否超过预定时间的效果。
            System.out.println("wait for " + timeoutMethod.getTimeout().value());
            ret = future.get(Integer.parseInt(timeoutMethod.getTimeout().value()), TimeUnit.MILLISECONDS);
            System.out.println("ret is got");
        }
        catch (InterruptedException e)
        {
            future.cancel(true);
            System.out.println("InterruptedException:" + timeoutMethod.getMethod().getName()+" : Time Out!!! Because @Timeout is set to " + timeoutMethod.getTimeout().value());
            throw new MyTimeoutException();
        }
        catch (ExecutionException e)
        {
            future.cancel(true);
            System.out.println("ExecutionException:"+timeoutMethod.getMethod().getName()+" : Time Out!!! Because @Timeout is set to " + timeoutMethod.getTimeout().value());
            throw new MyTimeoutException();
        }
        catch (TimeoutException e)
        {
            future.cancel(true);
            System.out.println("TimeoutException:"+timeoutMethod.getMethod().getName()+" : Time Out!!! Because @Timeout is set to " + timeoutMethod.getTimeout().value());
            throw new MyTimeoutException();
        }
        finally
        {
            executor.shutdown();
        }

        return ret;
    }

    private TimeoutMethod getTimeoutMethod(Method method)
    {
        List<TimeoutMethod> methodList = TimeoutMethodScanner.getTimeoutMethods(this.target.getClass().getName());

        for (TimeoutMethod tm : methodList)
        {
            if (compareMethods(method, tm.getMethod()))
                return tm;
        }

        return null;
    }

    private boolean compareMethods(Method method1, Method method2)
    {
        if (!method1.getName().equals(method2.getName()))
        {
            return false;
        }
        Class<?>[] cls1 = method1.getParameterTypes();
        Class<?>[] cls2 = method2.getParameterTypes();
        if (cls1.length != cls2.length)
        {
            return false;
        }
        int len = cls1.length;

        //防止多态
        for (int i = 0; i < len; i++)
        {
            Class<?> clazz1 = cls1[i];
            Class<?> clazz2 = cls2[i];
            if (!clazz1.getName().equals(clazz2.getName()))
            {
                return false;
            }
        }
        return true;
    }
}
