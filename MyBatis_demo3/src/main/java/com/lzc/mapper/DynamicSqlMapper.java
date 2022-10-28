package com.lzc.mapper;

import com.lzc.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @title: DynamicSqlMapper
 * @Author luozouchen
 * @Date: 2022/10/28 20:07
 */
public interface DynamicSqlMapper {
    /**
     * 实现多条件查询
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 测试choose,when,otherwise
     */
    List<Emp> getEmptyByChoose(Emp emp);

    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过List集合实现批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);

}
