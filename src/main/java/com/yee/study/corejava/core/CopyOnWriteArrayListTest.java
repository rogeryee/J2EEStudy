package com.yee.study.corejava.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: RogerYee
 * Create: 11/24/16
 */
public class CopyOnWriteArrayListTest
{
    public static void main(String[] args) throws Exception
    {
//        List<Integer> list = new ArrayList<>(); // 使用ArrayList会产生 ArrayIndexOutOfBoundsException
        List<Integer> list = new CopyOnWriteArrayList<>();

        AddThread t1 = new AddThread(list, 0);
        AddThread t2 = new AddThread(list, 200);
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(t1);
        es.execute(t2);

        while(!t1.completed || !t2.completed)
        {
            Thread.sleep(1000);
        }

        for(Integer i : list)
        {
            System.out.println(i);
        }
    }
}

class AddThread implements Runnable
{
    public boolean completed;

    private List<Integer> list;

    private int start;

    public AddThread(List<Integer> list, int start) {
        this.list = list;
        this.start = start;
    }

    @Override
    public void run() {
        for(int i = start; i < start + 100; ++i) {
            list.add(i);
        }

        completed = true;
    }
}
