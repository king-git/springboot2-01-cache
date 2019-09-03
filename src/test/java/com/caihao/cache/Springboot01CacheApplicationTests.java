package com.caihao.cache;

import com.caihao.cache.bean.Employee;
import com.caihao.cache.mapper.EmpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Autowired
    private EmpMapper empMapper;


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    @Test
    public void contextLoads() {

        Employee emp = empMapper.getEmpById(1);
        System.err.println("emp===="+emp);

    }


    @Test
    public void t02(){
        Employee emp = empMapper.getEmpById(1);
        //redisTemplate.opsForValue().set("emp-01",emp);
        empRedisTemplate.opsForValue().set("emp-02",emp);
    }

    @Test
    public void t01(){

        //stringRedisTemplate.opsForValue().append("msg","hellooooo");


        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.err.println("msg======"+msg);
         
    }

}
