package com.lzc.test;

import com.lzc.mapper.DeptMapper;
import com.lzc.mapper.DynamicSqlMapper;
import com.lzc.pojo.Emp;
import com.lzc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @title: DynamicSqlMapperTest
 * @Author luozouchen
 * @Date: 2022/10/28 20:14
 */
public class DynamicSqlMapperTest {
    /**
     * 动态sql:
     * 1.if:根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到sQL中
     * 2.where:
     * 当where 标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or 去掉
     * 当where标签中没有内容时，此时where 标签没有任何效果
     * 注意:where标签不能去掉条件后多余的and/or
     * 3.trim用于去掉或添加标签中的内容
     * - 常用属性
     *  - prefix：在trim标签中的内容的前面添加某些内容
     *   -suffix：在trim标签中的内容的后面添加某些内容
     *   -prefixOverrides：在trim标签中的内容的前面去掉某些内容
     *   -suffixOverrides：在trim标签中的内容的后面去掉某些内容
     *   若trim中的标签都不满足条件，则trim标签没有任何效果，也就是只剩下`select * from t_emp`
     *
     *   choose、when、otherwise`相当于`if...else if..else
     *   when至少要有一个，otherwise至多只有一个
     * 5.foreach
     * - 属性：
     *  - collection：设置要循环的数组或集合
     *    - item：表示集合或数组中的每一个数据
     *    - separator：设置循环体之间的分隔符，分隔符前后默认有一个空格，如` , `
     *    - open：设置foreach标签中的内容的开始符
     *    - close：设置foreach标签中的内容的结束符
     * 6.sql标签
     *   sql片段，可以记录一段公共sql片段，在使用的地方通过include标签进行引入
     *   - 声明sql片段：`<sql>`标签
     * <sql id="empColumns">eid,emp_name,age,sex,email</sql>
     *   引用sql片段：`<include>`标签
     *   <include refid="empColumns"></include>
     * -
     */
    @Test
    public void testEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> empByCondition = mapper.getEmpByCondition(new Emp(null, null, null, null, null));
        System.out.println(empByCondition);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> empByCondition = mapper.getEmptyByChoose(new Emp(null, "张三", 23, "男", "123@qq.com"));
        System.out.println(empByCondition);
    }

    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        int i = mapper.deleteMoreByArray(new Integer[]{8,9,10});

        System.out.println(i);
    }

    @Test
    public void insertMoreByList() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp emp1 = new Emp(null,"a",1,"男","123@321.com",null);
        Emp emp2 = new Emp(null,"b",1,"男","123@321.com",null);
        Emp emp3 = new Emp(null,"c",1,"男","123@321.com",null);
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        System.out.println(emps);
        int i = mapper.insertMoreByList(emps);
        System.out.println(i);
    }
}
