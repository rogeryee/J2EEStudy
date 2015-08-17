package com.yee.study.rabbitmq.helloworld;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Author: RogerYee
 * Create: 8/17/15
 */
public class Receiver
{
    static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        logger.debug("Receiver is waiting for the message!");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                logger.debug(" Receiver received message - ['" + message + "']");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
