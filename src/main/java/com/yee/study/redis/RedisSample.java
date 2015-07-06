package com.yee.study.redis;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * Author: RogerYee
 */
public class RedisSample
{
    private RedisTemplate<String, String> template;

    public void getStringFromRedis()
    {
        this.getTemplate().opsForValue().set("client", "First Capital");

        String ret = this.getTemplate().opsForValue().get("client");

        System.out.println("getStringFromRedis: ret is " + ret);
    }

    // Setters and Getters
    public RedisTemplate<String, String> getTemplate()
    {
        return template;
    }

    public void setTemplate(RedisTemplate<String, String> template)
    {
        this.template = template;
    }
}
