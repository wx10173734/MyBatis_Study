package com.lzc.mapper;

import com.lzc.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @title: EmpMapper
 * @Author luozouchen
 * @Date: 2022/10/28 14:35
 */
public interface EmpMapper {

    /**
     * 查询所有的员工信息
     */
    List<Emp> getAllEmp();

    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分步查询员工以及员工所对应的部门信息
     * 分步查询第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);
}
