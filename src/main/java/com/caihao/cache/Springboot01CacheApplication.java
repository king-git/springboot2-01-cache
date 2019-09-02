package com.caihao.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * 一、搭建基本的环境
 *  1.在MySQL中创建数据表department和employee
 *  2.创建Javabean封装数据库表
 *  3.整合mybatis
 *      1.配置数据源信息
 *      2.使用注解版的mybatis
 *          1）@mapperscan 指定需要扫描的mapper接口
 *
 */
@SpringBootApplication
@MapperScan("com.caihao.cache.mapper")
@EnableCaching
public class Springboot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01CacheApplication.class, args);
    }

}
