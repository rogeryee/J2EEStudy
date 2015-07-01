package com.yee.study.corejava.concurrency;

import java.util.concurrent.*;

public class FutureTaskTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
    {
		Callable<String> task = new Callable<String>()
		{
			public String call()
			{
				try
				{
					TimeUnit.SECONDS.sleep(3);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("Execute callable task");
				return "time=" + System.currentTimeMillis();
			}
		};

		// Use Thread Object to execute the FutureTask
		FutureTask<String> futureTask = new FutureTask<String>(task);
		new Thread(futureTask).start();
		try
		{
			System.out.println("Use Thread:");
			System.out.println("waiting execute result");
			System.out.println("result = " + futureTask.get());
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (ExecutionException e)
		{
			e.printStackTrace();
		}

		// Use ExecutorService to execute the FutureTask
		FutureTask<String> futureTask2 = new FutureTask<String>(task);
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.submit(futureTask2);

		try
		{
			System.out.println("Use ExecutorService:");
			System.out.println("waiting execute result");
			System.out.println("result = " + futureTask2.get(5000, TimeUnit.MILLISECONDS));
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (ExecutionException e)
		{
			e.printStackTrace();
		}
        catch (TimeoutException e)
        {
            e.printStackTrace();
        }

		es.shutdown();
	}

}
