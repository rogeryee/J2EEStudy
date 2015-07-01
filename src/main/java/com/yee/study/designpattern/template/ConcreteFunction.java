package com.yee.study.designpattern.template;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/12/14
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConcreteFunction extends AbstractFunction
{
    @Override
    public void subFunction1()
    {
        System.out.println("subFunction1");
    }

    @Override
    public void subFunction2()
    {
        System.out.println("subFunction2");
    }
}
