package com.lzc.test;

import com.lzc.mapper.SelectMapper;
import com.lzc.pojo.User;
import com.lzc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @title: SelectMapperTest
 * @Author luozouchen
 * @Date: 2022/10/28 2:29
 */
public class SelectMapperTest {
    /**
     * MyBatis的各种查询功能:
     * 1，若查询出的数据只有1条，可以通过实体类对象或者集合接收
     * a>可以通过实体类对象接收
     * b>可以通过list集合接收
     * c>可以通过map集合接收
     * 结果: { password=123456, sex=男， id=3, age=23, email=1234 5@qq. com, username=admin}
     * 2，若查询出的数据有多条，
     * a>可以通过List集合接受，
     * b>可以通过map,类型的ist集合接收
     * c>可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，放在同一个Map集合
     * 注意:定不能通过实体类对象接收，此时会抛异常TooManyResultsException
     *MyBatis中设置了默认的类型别名
     * java. lang. Integer-->int, integer
     * int--> int, integer
     * Map-- >map
     * String-->string
     *
     *
     */
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User userById = mapper.getUserById(3);
        System.out.println(userById);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdtoMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdtoMap = mapper.getUserByIdtoMap(3);
        System.out.println(userByIdtoMap);
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }
}
