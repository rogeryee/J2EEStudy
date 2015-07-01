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
    }
}
