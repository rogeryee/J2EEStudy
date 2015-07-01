package com.yee.study.designpattern.factory.simpleFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/12/14
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Factory
{
    public static Sample create(int which)
    {
        if(which == 1)
            return new SampleA();
        else
            return new SampleB();
    }
}
