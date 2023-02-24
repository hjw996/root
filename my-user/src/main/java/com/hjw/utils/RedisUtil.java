package com.hjw.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 添加数据
     * @param key
     * @param value
     */
    public void set(String key,Object value){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
    }


    /**
     * 获取数据
     * @param key
     */
    public Object get(String key){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }


}
