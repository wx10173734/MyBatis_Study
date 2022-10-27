package com.lzc.test;

import com.lzc.mapper.ParameterMapper;
import com.lzc.pojo.User;
import com.lzc.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: ParameterMapperTest
 * @Author luozouchen
 * @Date: 2022/10/28 0:44
 */
public class ParameterMapperTest {
    /**
     * MyBatis获取参数值的两种方式：${}和#{}
     * ${}的本质就是字符串拼接
     * #{}的本质就是占位符赋值
     * MyBatis获取参数值的各种情况:
     * 1. mapper接口方法的参数为单个的字面量类型
     * 可以通过${}和#{}以任意的名称获取参数值，但是需要注意${}的单引号问题
     * 2. mapper接口方法的参数为多个时
     * 此时MyBatis会将这些参数放在一 个map集合中，以两种方式进行存储
     * a> arg0, arg1...为键，以参数为值
     * b>以param1, param2...为键，以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 3.若mapper接口方法的参数有多个时，可以手动将这 些参数放在一个map 中存储
     * 只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 4.mapper接口方法的参数是实体类类型的参数
     * 只需要酒过#{}秘{}以属性的方式访问属性值即可，但是需要注意{}的单引号问题
     * 5.使用@Param注解命名参数
     * a>以@Param注解的值为键，以参数为值
     * b>以param1, param2...为键，以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * @throws IOException
     */
    @Test
    public void testGetAllUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }


    @Test
    public void testGetUserByUsername() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User admin = mapper.getUserByUserName("admin");
        System.out.println(admin);
    }

    @Test
    public void testCheckLogin() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User admin = mapper.checkLogin("admin","123");
        System.out.println(admin);
    }

    @Test
    public void testCheckLoginByMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123");
        User admin = mapper.checkLoginByMap(map);
        System.out.println(admin);
    }

    @Test
    public void testInsertUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int i = mapper.insertUser(new User(null, "罗邹晨", "123", 21, "男", "11@qq.com"));
        System.out.println(i);
    }

    @Test
    public void testCheckLoginByParam() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User admin = mapper.checkLoginByParam("admin","123");
        System.out.println(admin);
    }


}
