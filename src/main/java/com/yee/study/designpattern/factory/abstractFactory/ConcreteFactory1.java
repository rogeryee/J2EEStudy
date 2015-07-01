package com.yee.study.designpattern.factory.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/12/14
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConcreteFactory1 extends AbstractFactory
{
    @Override
    public IProductA createProductA()
    {
        return new ProductA1();
    }

    @Override
    public IProductB createProductB()
    {
        return new ProductB1();
    }
}
