package com.yee.study.corejava.concurrency.ProducerConsumerFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 8/26/14
 * Time: 11:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class Scheduler
{
    private List<Runnable> workThreads;
    private Executor executor = Executors.newCachedThreadPool();

    public Scheduler()
    {
        this.workThreads = new ArrayList<Runnable>();
    }

    public void addWorkThread(Runnable workThread)
    {
        if (this.workThreads == null)
            return;

        this.workThreads.add(workThread);
    }

    public void addWorkThreads(List<Runnable> workThreads)
    {
        if (workThreads == null || workThreads.isEmpty()) return;

        this.workThreads.addAll(workThreads);
    }

    public void start()
    {
        if (this.workThreads == null || this.workThreads.isEmpty())
            return;

        this.executor = Executors.newFixedThreadPool(this.workThreads.size());

        for (Runnable workThread : this.workThreads)
        {
            this.executor.execute(workThread);
        }
    }
}
