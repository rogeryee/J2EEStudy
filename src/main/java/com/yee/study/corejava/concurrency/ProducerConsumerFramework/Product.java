package com.yee.study.corejava.concurrency.ProducerConsumerFramework;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/26/14
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Product
{
    private String name;

    public Product(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return this.name;
    }
}
