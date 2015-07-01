package com.yee.study.designpattern.factory.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/12/14
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConcreteFactory2 extends AbstractFactory
{
    @Override
    public IProductA createProductA()
    {
        return new ProductA2();
    }

    @Override
    public IProductB createProductB()
    {
        return new ProductB2();
    }
}
