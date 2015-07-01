package com.yee.study.corejava.concurrency;

public class VolatileTest
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread[] threads = new Thread[1000];
		for (int i = 0; i < 1000; i++)
		{
			threads[i] = new Thread()
			{
				public void run()
				{
					CounterWithVolatile.inc();
				}
			};
			threads[i].start();
		}

		for (int i = 0; i < 1000; i++)
		{
			threads[i].join();
		}

		// 虽然我们在count变量前添加了volatile修饰，但结果并没有如我们预期等于1000
		System.out.println("CounterWithVolatile = " + CounterWithVolatile.getCount());
	}
}

class CounterWithVolatile
{
	private volatile static int count = 0;

	public static void inc()
	{
		try
		{
			Thread.sleep(1);
		}
		catch (InterruptedException e)
		{
		}
		
		CounterWithVolatile.count++;
	}

	public static int getCount()
	{
		return CounterWithVolatile.count;
	}
}
