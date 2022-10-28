package com.lzc.mapper;

import com.lzc.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @title: DeptMapper
 * @Author luozouchen
 * @Date: 2022/10/28 14:35
 */
public interface DeptMapper {
    /**
     * 通过分步查询员工以及员工所对应的部门信息
     * 分步查询第二步：查询did查询员工所对应的部门
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);


    /**
     * 获取部门以及部门中所有员工的信息
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过分布查询查询部门以及部门中所有的员工信息
     * 第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
