package com.lzc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @title: User
 * @Author luozouchen
 * @Date: 2022/10/27 22:16
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;
}
