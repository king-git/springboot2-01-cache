package com.caihao.cache.mapper;

import com.caihao.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author CaiHao
 * @create 2019-09-02 下午 17:01:40
 */
@Mapper
public interface EmpMapper {

    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName}")
    public void  updEmp(Employee employee);


    @Delete("delete form employee where id=#{id}")
    public void delemp(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) valuse(#{lastName},#{email},#{gender},#{dId})")
    public void addemp(Employee employee);


    @Select("select * from employee where lastName=#{lastName}")
    public Employee getEmpByLastName(String lastName);
}
