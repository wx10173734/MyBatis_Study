package com.lzc;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzc.mapper.EmpMapper;
import com.lzc.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @title: PageHelperTest
 * @Author luozouchen
 * @Date: 2022/10/29 21:04
 */
public class PageHelperTest {
    /**
     * limit index,pageSize
     * index:当前页的起始索引
     * pageSize:每页显示的条数
     * pageNum:当前页的页码
     * index = (pageNum-1)*pageSize
     * <p>
     * <p>
     * 使用mybatis分页插件实现分页功能:
     * 1.需要在查询功能之前开启分页
     * PageHelper.startPage(int pageNum,int pageSize);
     * 2.在查询之后获取相关信息
     *         PageInfo<Emp> page = new PageInfo<>(list, 5);
     *         list表示分页数据
     *         5表示当前导航分页的数量
     * @throws IOException
     */
    @Test
    public void testPageHelper() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        PageHelper.startPage(6, 4);
//        System.out.println(page);
        List<Emp> list = mapper.selectByExample(null);
        PageInfo<Emp> page = new PageInfo<>(list, 11);
        System.out.println(page);
        list.forEach(emp -> System.out.println(emp));

    }
}
