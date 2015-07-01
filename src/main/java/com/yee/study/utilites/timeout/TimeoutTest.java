package com.yee.study.utilites.timeout;

/**
 * User: RogerYee
 * <p/>
 * 测试类
 */
public class TimeoutTest implements ITimeoutTest
{
    public TimeoutTest()
    {
    }

    @Timeout("2000")
    public void testMethod1()
    {
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("testMethod2 completes");
    }

    @Timeout("5000")
    public void testMethod2()
    {
        System.out.println("testMethod2 completes");
    }

    public void testMethod3()
    {
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
