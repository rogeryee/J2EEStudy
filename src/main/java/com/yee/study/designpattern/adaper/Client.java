package com.yee.study.designpattern.adaper;

/**
 * Author: RogerYee
 */
public class Client
{
    public static void main(String [] args)
    {
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}
