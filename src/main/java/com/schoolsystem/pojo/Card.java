package com.schoolsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private int id;         // 学号
    private String name;    // 姓名
    private String balance; // 余额
}
