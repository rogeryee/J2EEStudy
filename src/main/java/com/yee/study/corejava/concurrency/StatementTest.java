package com.yee.study.corejava.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 本例展示了多线程的应用：
 * 多个线程读取Account的数据，并处理。
 * 处理完以后多个线程需要按照原有的顺序进行输出。
 */
public class StatementTest
{
    public static void main(String[] args) throws InterruptedException
    {
        long start = System.currentTimeMillis();
        StatementTestData data = new StatementTestData();

        int threadNumber = 10;
        Thread[] threads = new Thread[threadNumber];
        for(int i=0;i<threadNumber;i++)
        {
            threads[i] = new Thread(new AccountWriter(data),"Thread-"+i);
            threads[i].start();
        }

        for(int i=0;i<threadNumber;i++)
        {
            threads[i].join();
        }
        long end = System.currentTimeMillis();
        System.out.println("Cost = " + (end-start));
    }
}

class StatementTestData
{
    private int acctSequence = 0;
    private int processedAcctSeq = 0;
    public List<StatementTestAccount> data = Collections.synchronizedList(new ArrayList<StatementTestAccount>());

    public StatementTestData()
    {
        for (int i = 0; i < 10000; i++)
        {
            this.data.add(new StatementTestAccount("Roger" + i));
        }
    }

    public synchronized StatementTestAccount getNextAccount()
    {
        if (this.acctSequence >= this.data.size())
            return null;

        StatementTestAccount ret = this.data.get(this.acctSequence);
        ret.setAcctSequence(this.acctSequence);
        this.acctSequence++;
        return ret;
    }

    public synchronized void increaseProcessedAcctSeq()
    {
        this.processedAcctSeq++;
    }

    public synchronized int getProcessedAcctSeq()
    {
        return this.processedAcctSeq;
    }
}

class StatementTestAccount
{
    private int acctSequence;
    private String name;

    public StatementTestAccount(String name)
    {
        this.name = name;
    }

    void setAcctSequence(int acctSequence)
    {
        this.acctSequence = acctSequence;
    }

    public int getAcctSequence()
    {
        return acctSequence;
    }

    public String getName()
    {
        return name;
    }
}

class AccountWriter implements Runnable
{
    private StatementTestData data;

    public AccountWriter(StatementTestData data)
    {
        this.data = data;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        while (true)
        {
            StatementTestAccount account = data.getNextAccount();
            if (account == null)
            {
                break;
            }
            else
            {
                synchronized (this.data)
                {
                    while (data.getProcessedAcctSeq() != account.getAcctSequence())
                    {

                        try
                        {
                            this.data.wait();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getName() + ": Account = " + account.getName());
                    this.data.increaseProcessedAcctSeq();
                    this.data.notifyAll();
                }
            }
        }
    }
}