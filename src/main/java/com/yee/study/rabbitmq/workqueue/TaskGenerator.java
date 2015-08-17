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
    private static final String TASK_QUEUE_NAME = "ry_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

//        String message = getMessage(argv);
//
//        channel.basicPublish("", TASK_QUEUE_NAME,
//                MessageProperties.PERSISTENT_TEXT_PLAIN,
//                message.getBytes("UTF-8"));
//        System.out.println(" [x] Sent '" + message + "'");

        String[] messages = new String[]{"Hello World 1", "Hello World 2", "Hello World 3", "Hello World 4"};
        for(String msg:messages)
        {
            channel.basicPublish("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    msg.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + msg + "'");
        }


        channel.close();
        connection.close();
    }

    private static String getMessage(String[] strings) {
        if (strings.length < 1)
            return "Hello World!";
        return joinStrings(strings, " ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}
