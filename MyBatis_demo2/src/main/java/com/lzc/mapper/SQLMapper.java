package com.lzc.mapper;

import com.lzc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @title: SQLMapper
 * @Author luozouchen
 * @Date: 2022/10/28 3:07
 */
public interface SQLMapper {
    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);
}
