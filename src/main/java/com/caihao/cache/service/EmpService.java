package com.caihao.cache.service;

import com.caihao.cache.bean.Employee;
import com.caihao.cache.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author CaiHao
 * @create 2019-09-02 下午 18:33:26
 *
 *
 * @CacheConfig 标注在类上，表示这个类中所有方法的缓存都公用的属性
 *
 *
 */
@Service

//@CacheConfig(cacheNames = "emp")
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 创建缓存
     * @param id
     * @return
     */

    //@Cacheable(cacheNames = "emp",key = "#root.methodName+'['+#id+']'")
    //@Cacheable(value = {"emp"},keyGenerator = "myKeygenerator")
    //@Cacheable(value = {"emp"},keyGenerator = "myKeygenerator",condition = "#a0 > 1")
    //@Cacheable(value = {"emp"},keyGenerator = "myKeygenerator",condition = "#a0 > 1",unless = "#a0 == 2")
    @Cacheable(value = "emp")
    public Employee getemp(Integer id){
        System.err.println("查询==="+id+"号员工");

        Employee emp = empMapper.getEmpById(id);
        return emp;
    }


    /**
     * 缓存更新
     * @param employee
     * @return
     *
     * @CachePut 他标注的方法一定会执行
     *
     */

    //@CachePut(value= {"emp"},key = "#employee.id")
    @CachePut(value= {"emp"},key = "#result.id")
    public Employee updemp(Employee employee){
        System.err.println("更新的emp======"+employee);
         
        empMapper.updEmp(employee);

        return employee;
    }


    /**
     * 清除缓存
     * @param id
     *
     * key = "#id"  按照指定的key清除缓存
     * allEntries = true  清除名称是value=emp的所有缓存
     * beforeInvocation 缓存的清除是否在方法执行之前
     *  默认为false，表示在方法执行之后清除缓存，如果该方法内出现异常，缓存不清除
     *  为true时：清除缓存在执行方法之前进行，无论方法内是否有异常，缓存都会被清除
     */
    //@CacheEvict(value = "emp",key = "#id")
    @CacheEvict(value = "emp",allEntries = true)
    public  void delemp(Integer id){
        System.err.println("删除员工====="+id);
         
        //empMapper.delemp(id);
    }



    @Caching(
            cacheable = {
                    @Cacheable(value = {"emp"},key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getempBylastName(String lastName){

        Employee emp = empMapper.getEmpByLastName(lastName);
        return emp;
    }



}
