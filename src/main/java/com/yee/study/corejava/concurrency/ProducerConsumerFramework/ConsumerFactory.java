package com.yee.study.corejava.concurrency.ProducerConsumerFramework;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/26/14
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConsumerFactory implements IConsumerFactory
{
    @Override
    public IConsumer createConsumer()
    {
        return new Consumer();
    }
}
