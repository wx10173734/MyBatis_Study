package com.lzc.test;

import com.lzc.mapper.SQLMapper;
import com.lzc.mapper.SelectMapper;
import com.lzc.pojo.User;
import com.lzc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @title: SQLMapperTest
 * @Author luozouchen
 * @Date: 2022/10/28 3:09
 */
public class SQLMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> a = mapper.getUserByLike("a");
        System.out.println(a);
    }
    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int i = mapper.deleteMore("1,2,3");
        System.out.println(i);
    }
    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        System.out.println(mapper.getUserByTableName("t_user"));
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "lzc", "123", 23, "男", "1@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

}
