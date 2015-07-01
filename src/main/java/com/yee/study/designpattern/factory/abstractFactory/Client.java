package com.yee.study.designpattern.factory.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/12/14
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Client
{
    public static void main(String [] args)
    {
        AbstractFactory factory1 = new ConcreteFactory1();
        IProductA productA1 = factory1.createProductA();
        IProductB productB1 = factory1.createProductB();
    }
}
