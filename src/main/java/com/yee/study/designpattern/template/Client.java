package com.yee.study.designpattern.template;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/12/14
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client
{
    public static void main(String [] args)
    {
        AbstractFunction function = new ConcreteFunction();
        function.mainFunction();
    }
}
