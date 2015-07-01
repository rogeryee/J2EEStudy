package com.yee.study.corejava.concurrency.ProducerConsumerFramework;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/26/14
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Consumer implements IConsumer
{
    private ConcurrentLinkedQueue<Product> storage;

    public Consumer()
    {
    }

    public Consumer(ConcurrentLinkedQueue storage)
    {
        this.storage = storage;
    }

    public void setStorage(ConcurrentLinkedQueue<Product> storage)
    {
        this.storage = storage;
    }

    public ConcurrentLinkedQueue<Product> getStorage()
    {
        return storage;
    }

    @Override
    public void consume()
    {
        if (this.storage == null)
            return;

        Product product = this.storage.poll();
        System.out.println("Thread["+Thread.currentThread().getId()+"] consumes the product[" + product + "]");
    }

    @Override
    public void run()
    {
        int i=0;
        while (i<=100)
        {
            this.consume();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
