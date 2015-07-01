package com.yee.study.corejava.core;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 7/2/14
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class AutoCloseSample
{
    public static void main(String[] args)
    {
        try(ResourceWithAutoCloseable resource = new ResourceWithAutoCloseable();)
        {
            resource.read();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class ResourceWithAutoCloseable implements AutoCloseable
{
    @Override
    public void close() throws Exception
    {
        System.out.println("ResourceWithAutoCloseable-->close()");
    }

    public void read()
    {
        System.out.println("ResourceWithAutoCloseable-->read()");
    }
}
