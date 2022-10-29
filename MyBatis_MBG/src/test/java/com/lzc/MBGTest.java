package com.lzc;

import com.lzc.mapper.EmpMapper;
import com.lzc.pojo.Emp;
import com.lzc.pojo.EmpExample;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class MBGTest {
    @Test
    public void testMBG() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//            //查询所有数据
//            List<Emp> list = mapper.selectByExample(null);
//            list.forEach(emp -> System.out.println(emp));
            //根据条件查询
//            EmpExample example = new EmpExample();
//            example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
//            example.or().andDidIsNotNull();
//            List<Emp> list = mapper.selectByExample(example);
//            System.out.println(list);
            mapper.updateByPrimaryKeySelective(new Emp(1, "admin1", 22, null, "444@qq.com", 3));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
