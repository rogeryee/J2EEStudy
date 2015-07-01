package com.yee.study.corejava.concurrency.ProducerConsumerFramework;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/26/14
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProducerFactory implements IProducerFactory
{
    @Override
    public IProducer createProducer()
    {
        return new Producer();
    }
}
