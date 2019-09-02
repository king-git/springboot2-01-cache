package com.caihao.cache.service;

import com.caihao.cache.bean.Employee;
import com.caihao.cache.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CaiHao
 * @create 2019-09-02 下午 18:33:26
 */
@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    public Employee getemp(Integer id){
        System.err.println("查询==="+id+"号员工");

        Employee emp = empMapper.getEmpById(id);
        return emp;
    }





}
