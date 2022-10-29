package com.lzc.mapper;

import com.lzc.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @title: CacheMapper
 * @Author luozouchen
 * @Date: 2022/10/29 19:33
 */
public interface CacheMapper {

    Emp getEmpByEid(@Param("eid") Integer eid);

    void insertEmp(Emp emp);
}
