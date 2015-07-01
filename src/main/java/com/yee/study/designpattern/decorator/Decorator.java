package com.yee.study.designpattern.decorator;

/**
 * Author: RogerYee
 */
public class Decorator implements Component
{
    private Component component;

    public Decorator(Component component)
    {
        this.component = component;
    }

    @Override
    public void operation()
    {
        this.component.operation();
    }
}
