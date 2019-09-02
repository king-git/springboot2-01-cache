package com.caihao.cache;

import com.caihao.cache.bean.Employee;
import com.caihao.cache.mapper.EmpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void contextLoads() {

        Employee emp = empMapper.getEmpById(1);
        System.err.println("emp===="+emp);


    }

}
