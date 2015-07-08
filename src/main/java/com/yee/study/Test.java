package com.yee.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 6/27/14
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test
{
    static Logger logger = LoggerFactory.getLogger(Test.class);

//    public static void main(String [] arg)
//    {
//        Singleton singleton = Singleton.getInstance();
//        logger.debug("a = {}", singleton.a);
//        logger.debug("b = {}", singleton.b);
//    }
//}
//
//class Singleton
//{
//    private static Singleton instance = new Singleton();
//
//    public static int a;
//    public static int b = 0;
//
//    private Singleton()
//    {
//        a++;
//        b++;
//    }
//
//    public static Singleton getInstance()
//    {
//        return instance;
//    }
//}
    public static int k = 0;
    public static Test t1 = new Test("t1");
    public static Test t2 = new Test("t2");
    public static int i = print("i");
    public static int n = 99;

    public int j = print("j");

    {
        print("构造快");
    }

    static {
        print("静态块");
    }

    public Test(String str) {
        System.out.println((++k) + ":" + str + "    i=" + i + "  n=" + n);
        ++n;
        ++i;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "   n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {

    }
}

