package com.caihao.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author CaiHao
 * @create 2019-09-03 上午 09:56:53
 */
@Configuration
public class MycacheConfig {

    @Bean("myKeygenerator")
    public KeyGenerator keyGenerator(){

      //自定义生成的keygenerator规则
      return  new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                System.err.println("=====自定义的keygenerator====");

                return method.getName()+"["+Arrays.asList(objects).toString()+"]";
            }
        };

    }
}
