package com.lzc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @title: Dept
 * @Author luozouchen
 * @Date: 2022/10/28 14:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dept {
    private Integer did;
    private String deptName;
}
