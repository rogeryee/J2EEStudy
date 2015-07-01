package com.yee.study.designpattern.factory.simpleFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/12/14
 * Time: 10:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class Client
{
    public static void main(String [] args)
    {
        Sample sample = Factory.create(1);
    }
}
