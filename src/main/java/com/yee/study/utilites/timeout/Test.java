package com.yee.study.utilites.timeout;

/**
 * Created with IntelliJ IDEA.
 * User: RogerYee
 * Date: 9/12/14
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public class Test
{
    public static void main(String [] args)
    {
        ITimeoutTest test = (ITimeoutTest)Factory.getObject(TimeoutTest.class);
//        test.testMethod1();
        test.testMethod2();
//        test.testMethod3();
    }
}
