package com.yee.study.designpattern.decorator;

/**
 * Author: RogerYee
 */
public class ConcreteComponent implements Component
{
    @Override
    public void operation()
    {
        System.out.println("ConcreteComponent:operation()");
    }
}
