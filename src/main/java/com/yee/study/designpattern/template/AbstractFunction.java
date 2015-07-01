package com.yee.study.designpattern.template;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/12/14
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractFunction
{
    public void mainFunction()
    {
        this.subFunction1();
        this.subFunction2();
    }

    public abstract void subFunction1();
    public abstract void subFunction2();
}
