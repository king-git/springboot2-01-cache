package com.caihao.cache.config;

import com.caihao.cache.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author CaiHao
 * @create 2019-09-03 下午 16:27:54
 */
@Configuration
public class MyredisConfig {

    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);

        //修改redis默认的序列化器 改成json格式的
        Jackson2JsonRedisSerializer<Employee> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);

        return template;
    }


    //自定义cachemanager
    /*public RedisCacheManager empRedisCacheManager(RedisTemplate<Object, Employee> empRedisTemplate){

          return null;
    }*/



}
