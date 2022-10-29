package com.lzc.test;

import com.lzc.mapper.CacheMapper;
import com.lzc.pojo.Emp;
import com.lzc.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @title: CacheMapperTest
 * @Author luozouchen
 * @Date: 2022/10/29 19:37
 */
public class CacheMapperTest {
    @Test
    public void testOneCache() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid1 = mapper1.getEmpByEid(1);
        //mapper1.insertEmp(new Emp(null,"abc",23,"男","123@qq.com"));
        sqlSession.clearCache();
        Emp empByEid2 = mapper1.getEmpByEid(1);
        System.out.println(empByEid2);
//
//        CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);
//        Emp empByEid2 = mapper2.getEmpByEid(1);
//        System.out.println(empByEid2);
    }

    @Test
    public void TwoCache() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(1));
            //缓存失效
            mapper1.insertEmp(new Emp(null,"abc",23,"男","123@qq.com"));

            sqlSession1.close();
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSession2.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
