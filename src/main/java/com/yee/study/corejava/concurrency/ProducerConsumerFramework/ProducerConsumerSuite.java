package com.yee.study.corejava.concurrency.ProducerConsumerFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/26/14
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProducerConsumerSuite
{
    private List<Runnable> producers;
    private List<Runnable> consumers;
    private ConcurrentLinkedQueue<Product> storage;
    private IConsumerFactory consumerFactory;
    private IProducerFactory producerFactory;
    private int producerNumber;
    private int consumerNumber;

    public ProducerConsumerSuite(int producerNumber, int consumerNumber)
    {
        this.consumerNumber = consumerNumber;
        this.producerNumber = producerNumber;
        this.producers = new ArrayList<Runnable>();
        this.consumers = new ArrayList<Runnable>();
        this.storage = new ConcurrentLinkedQueue<Product>();
    }

    public void init()
    {
        for (int i = 0; i < this.producerNumber; i++)
        {
            Producer producer = (Producer)this.producerFactory.createProducer();
            producer.setStorage(this.storage);
            this.producers.add(producer);
        }

        for (int i = 0; i < this.consumerNumber; i++)
        {
            Consumer consumer = (Consumer)this.consumerFactory.createConsumer();
            consumer.setStorage(this.storage);
            this.consumers.add(consumer);
        }
    }

    public List<Runnable> getProducers()
    {
        return producers;
    }

    public void setProducers(List<Runnable> producers)
    {
        this.producers = producers;
    }

    public List<Runnable> getConsumers()
    {
        return consumers;
    }

    public void setConsumers(List<Runnable> consumers)
    {
        this.consumers = consumers;
    }

    public ConcurrentLinkedQueue<Product> getStorage()
    {
        return storage;
    }

    public void setStorage(ConcurrentLinkedQueue<Product> storage)
    {
        this.storage = storage;
    }

    public IConsumerFactory getConsumerFactory()
    {
        return consumerFactory;
    }

    public void setConsumerFactory(IConsumerFactory consumerFactory)
    {
        this.consumerFactory = consumerFactory;
    }

    public IProducerFactory getProducerFactory()
    {
        return producerFactory;
    }

    public void setProducerFactory(IProducerFactory producerFactory)
    {
        this.producerFactory = producerFactory;
    }
}
