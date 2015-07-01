package com.yee.study.corejava.concurrency.ProducerConsumerFramework;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/26/14
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Producer implements IProducer
{
    private ConcurrentLinkedQueue<Product> storage;

    private static int i = 0;

    public Producer()
    {
    }

    public Producer(ConcurrentLinkedQueue<Product> storage)
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
    public void produce()
    {
        if (this.storage == null)
            return;

        Product product = new Product(String.valueOf(i));
        this.storage.offer(product);
        System.out.println("Thread["+Thread.currentThread().getId()+"] produces the product[" + product + "]");

        i++;
    }

    @Override
    public void run()
    {
        int i=0;
        while(i<=100)
        {
            this.produce();
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
