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

}
