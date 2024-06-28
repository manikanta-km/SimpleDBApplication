package com.miko.simpledbapplication.util;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

    private final RedisTemplate<String, Long> redisTemplate;

    public RedisUtil(RedisTemplate<String, Long> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void incrementCounter(String key) {
        redisTemplate.opsForValue().increment(key, 1);
    }

    public Long getCounter(String key) {
        Long value = redisTemplate.opsForValue().get(key);
        return value != null ? value : 0L;
    }
}
