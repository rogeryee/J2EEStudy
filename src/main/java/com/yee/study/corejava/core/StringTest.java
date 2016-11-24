package com.yee.study.corejava.core;

/**
 * Created with IntelliJ IDEA.
 * User: RogerYee
 * Date: 9/11/14
 * Time: 11:47
 * To change this template use File | Settings | File Templates.
 */
public class StringTest
{
    public static void main(String[] args)
    {
        String a1 = "a";
        String a2 = "a";
        String a3 = new String("a");

        System.out.println(a1 == a2); // True
        System.out.println(a1 == a3); // False
        System.out.println(a2 == a3); // False

        System.out.println("---------------");

        String b1 = "b";
        String b2 = new String("b");
        String b3 = new String("b");
        System.out.println(b1 == b2); // False

        b2 = b2.intern();
        System.out.println(b1 == b2);

        System.out.println("---------------");

        String c1 = new String("c");
        String c2 = "c";
        System.out.println(c1 == c2); // False

        String d1 = new String("d");
        d1.intern();
        String d2 = "d";
        System.out.println(d1 == d2); // False

        System.out.println("---------------");

        String s = "s-ab";
        int i = 1;
        StringBuffer sb = new StringBuffer("sb-ab");
        TestObj obj = new TestObj("Roger", 12);
        change(s,i,sb,obj);

        System.out.println("s = " + s);
        System.out.println("i = " + i);
        System.out.println("sb = " + sb.toString());
        System.out.println("obj : " + obj.name + ", " + obj.age);
    }

    public static void change(String s, int i, StringBuffer sb, TestObj obj)
    {
        s = "s-cd";
        i = 3;
        sb.append("cd");

        obj.name = "Jack";
        obj.age = 100;
        sb = new StringBuffer("new sb");
        obj = new TestObj("Phoebe", 22);
    }
}

class TestObj
{
    public String name;

    public int age;

    public TestObj(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
}
