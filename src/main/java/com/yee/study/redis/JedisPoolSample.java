package com.yee.study.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Author: RogerYee
 */
public class JedisPoolSample
{
    static final Logger logger = LoggerFactory.getLogger(JedisPoolSample.class);

    private static JedisPool pool;

    public static JedisPool getPool()
    {
        if (pool == null)
        {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxWaitMillis(1000 * 100);
            config.setMaxIdle(5);

            pool = new JedisPool(config, "localhost", 6379);
        }

        return pool;
    }

    public static void closeResource(Jedis redis)
    {
        if (redis != null)
        {
            redis.close();
        }
    }

    public static void set(String key, String value)
    {
        Jedis jedis = null;

        try
        {
            JedisPool pool = getPool();
            jedis = pool.getResource();
            jedis.set(key, value);
        }
        catch (Exception e)
        {
            closeResource(jedis);
            e.printStackTrace();
        }
        finally
        {
            closeResource(jedis);
        }
    }

    public static String get(String key)
    {
        String value = null;
        Jedis jedis = null;

        try
        {
            JedisPool pool = getPool();
            jedis = pool.getResource();
            value = jedis.get(key);
        }
        catch (Exception e)
        {
            closeResource(jedis);
            e.printStackTrace();
        }
        finally
        {
            closeResource(jedis);
        }

        return value;
    }

    public static void main(String [] args)
    {
        String key = "foo", value = "bar";
        set(key, value);
        String result = get(key);
        logger.debug("Result from Redis is {}", result);
    }
}
