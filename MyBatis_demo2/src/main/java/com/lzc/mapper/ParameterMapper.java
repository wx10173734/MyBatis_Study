package com.lzc.mapper;

import com.lzc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @title: ParameterMapper
 * @Author luozouchen
 * @Date: 2022/10/28 0:38
 */
public interface ParameterMapper {
    /**
     * 查询所有员工信息
     */
    List<User> getAllUser();

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUserName(String username);

    /**
     * 验证登陆
     */
    User checkLogin(String username, String password);

    /**
     * 验证登陆(参数为Map)
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登陆(使用@Param)
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
