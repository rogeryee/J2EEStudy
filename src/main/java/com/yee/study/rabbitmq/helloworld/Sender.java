package com.yee.study.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Author: RogerYee
 * Create: 8/17/15
 */
public class Sender
{
    static final Logger logger = LoggerFactory.getLogger(Sender.class);

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "Hello World, Guy!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        logger.debug("Sender sent a message - [{}]", message);

        channel.close();
        connection.close();
    }
}
