package com.yee.study.designpattern.adaper;

/**
 * Author: RogerYee
 */
public class Adapter implements Target
{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee)
    {
        this.adaptee = adaptee;
    }

    @Override
    public void request()
    {
        this.adaptee.specialRequest();
    }
}
