package com.caihao.cache.controller;

import com.caihao.cache.bean.Employee;
import com.caihao.cache.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CaiHao
 * @create 2019-09-02 21:05:22
 */
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emp/{id}")
    public Employee getemp(@PathVariable("id") Integer id){

        Employee employee = empService.getemp(id);
        return employee;
    }


    @GetMapping("/emp")
    public Employee updemp(Employee employee){

        Employee emp = empService.updemp(employee);
        return emp;
    }


    @GetMapping("/delemp/{id}")
    public String delemp(@PathVariable("id") Integer id){

        empService.delemp(id);
        return "success";
    }


    @GetMapping("/emp/lastName/{lastName}")
    public Employee getempBylastname(@PathVariable("lastName") String lastName){

        System.err.println("按照名字查询======="+lastName);
         
        Employee employee = empService.getempBylastName(lastName);
        return employee;
    }


}
