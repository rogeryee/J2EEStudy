package com.yee.study.designpattern.decorator;

/**
 * Author: RogerYee
 */
public class ConcreteDecorator extends Decorator
{
    public ConcreteDecorator(Component component)
    {
        super(component);
    }

    public void operation()
    {
        super.operation();
        this.addFeature();
    }

    public void addFeature()
    {
        System.out.println("Decorator:operation()-->Add Feature");
    }
}
