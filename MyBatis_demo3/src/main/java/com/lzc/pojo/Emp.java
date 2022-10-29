package com.lzc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @title: Emp
 * @Author luozouchen
 * @Date: 2022/10/28 14:33
 */
@Data

@NoArgsConstructor
@ToString
public class Emp implements Serializable {
    private Integer eid;
    private String empName;
    private Integer age;
    private String sex;
    private String email;
    private Dept dept;

    public Emp(Integer eid, String empName, Integer age, String sex, String email) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public Emp(Integer eid, String empName, Integer age, String sex, String email, Dept dept) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.dept = dept;
    }
}
