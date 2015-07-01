package com.yee.study.corejava.concurrency.ProducerConsumerFramework;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/26/14
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class Test
{
    public static void main(String [] args)
    {
        Scheduler scheduler = new Scheduler();

        ProducerConsumerSuite suite = new ProducerConsumerSuite(2,2);
        suite.setProducerFactory(new ProducerFactory());
        suite.setConsumerFactory(new ConsumerFactory());
        suite.init();
        scheduler.addWorkThreads(suite.getConsumers());
        scheduler.addWorkThreads(suite.getProducers());

        scheduler.start();
    }
}
