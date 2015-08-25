package com.yee.study.quartz.helloworld;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Author: RogerYee
 * Create: 8/25/15
 */
public class HelloWorldScheduler
{
    public static void main(String [] args)
    {
        // Configure Job
        JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class).withIdentity("HelloWorldJob").build();

        // Configure Trigger
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

        // Start Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        try
        {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
        }
        catch (SchedulerException e)
        {
            e.printStackTrace();
        }
    }
}
