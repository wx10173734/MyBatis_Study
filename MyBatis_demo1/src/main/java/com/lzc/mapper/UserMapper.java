package com.lzc.mapper;

/**
 * @title: UserMapper
 * @Author luozouchen
 * @Date: 2022/10/27 22:18
 * @Version 1.0
 */
public interface UserMapper {
    /**
     * Mybatis 面向接口编程两个一致:
     *  1.映射文件的namespace要和mapper接口的全类名保持一致
     *  2.映射文件中 sql语句的id要和mapper接口中的方法名一致
     *
     *
     *  表--实体类--mapper接口--映射文件
     */


    /**
     * 添加用户信息
     */
    int insertUser();

}
