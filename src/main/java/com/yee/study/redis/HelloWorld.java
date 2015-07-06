package com.yee.study.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * 本例使用了JRedis直接操作Redis数据库
 * Author: RogerYee
 */
public class HelloWorld
{
    static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String [] args)
    {
        helloWorld();
    }

    /**
     * 直接操作Jedis对象，来访问Redis库
     */
    public static void helloWorld()
    {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("foo", "Hello World");
        String value = jedis.get("foo");

        logger.debug("Get value from redis and value is {}", value);
    }
}
