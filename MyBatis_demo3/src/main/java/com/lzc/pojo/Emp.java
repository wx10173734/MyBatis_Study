package com.lzc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @title: Emp
 * @Author luozouchen
 * @Date: 2022/10/28 14:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp {
    private Integer eid;
    private String empName;
    private Integer age;
    private String sex;
    private String email;
    private Dept dept;
}
