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
}
