package com.yee.study.designpattern;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 7/24/14
 * Time: 11:31 AM
 * 列举了单例模式几种不同的实现：
 * 饥饿型、懒汉型、懒汉型（DCL）和静态内部类型
 */
public class Singleton
{
    // 采用了一种新的模式——Initialization on Demand Holder.
    // 这种方法使用内部类来做到延迟加载对象，在初始化这个内部类的时候，JLS(Java Language Sepcification)会保证这个类的线程安全。
    private static class SingletonHolder
    {
        public final static Singleton instance = new Singleton();
    }

    public static Singleton getInstance()
    {
        return SingletonHolder.instance;
    }
}

/**
 * 饥饿型：存在潜在的性能问题
 */
class EagerSingleton
{
    private static EagerSingleton singObj = new EagerSingleton();

    private EagerSingleton()
    {
    }

    public static EagerSingleton getSingleInstance()
    {
        return singObj;
    }
}

/**
 * 懒汉模式:使用了延迟加载来保证对象在没有使用之前，是不会进行初始化的。
 * 注意在懒汉模式中需要添加synchronized关键字来保证线程安全。但是使用synchronized会带来性能的代价。
 */
class LazySingleton
{
    private static LazySingleton singObj = null;

    private LazySingleton()
    {
    }

    public static synchronized LazySingleton getSingleInstance()
    {
        if (null == singObj) singObj = new LazySingleton();
        return singObj;
    }
}

/**
 *  懒汉模式(DCL):使用双重检查锁（Double-Checked Lock）的方式来改进。
 *  但实际上DCL的程序在病发时依然会有问题，比如线程A、B同时调用该方法，而线程A正在初始化对象，但还没完成，这时线程B会获得一个没有完成初始化的对象。
 */
class DoubleCheckedSingleton
{
    private static DoubleCheckedSingleton singObj = null;

    private DoubleCheckedSingleton()
    {
    }

    public static DoubleCheckedSingleton getSingleInstance()
    {
        if (null == singObj)
        {
            synchronized (DoubleCheckedSingleton.class)
            {
                if (null == singObj)
                    singObj = new DoubleCheckedSingleton();
            }
        }
        return singObj;
    }
}
