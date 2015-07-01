package com.yee.study.corejava.core;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 7/22/14
 * Time: 3:36 PM
 * 本例用Unsafe实现了产生一个对象实例
 */
public class UnsafeTest
{
    public static void main(String[] args)
    {
        try
        {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);

            // This creates an instance of player class without any initialization
            PlayerWithUnsafe p = (PlayerWithUnsafe) unsafe.allocateInstance(PlayerWithUnsafe.class);
            System.out.println(p.getAge()); // Print 0

            p.setAge(45); // Let's now set age 45 to un-initialized object
            System.out.println(p.getAge()); // Print 45
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class PlayerWithUnsafe
{
    private int age = 12;

    private PlayerWithUnsafe()
    {
        this.age = 50;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
