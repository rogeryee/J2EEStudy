package com.yee.study.rabbitmq.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * Author: RogerYee
 * Create: 8/17/15
 */
public class TaskGenerator
{
    private static final String TASK_QUEUE_NAME = "task";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        boolean durable = true;
        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);

        for(int i = 0;i < 10; i++)
        {
            String msg = "Hello World " + i;
            channel.basicPublish("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    msg.getBytes("UTF-8"));
            System.out.println("Sent '" + msg + "'");
        }

        channel.close();
        connection.close();
    }
}
