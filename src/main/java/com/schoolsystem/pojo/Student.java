package com.schoolsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Student extends Account{
//    private Integer id;
    private String name;
    private String phone;

    private String major;

    private Integer classNumber;

    private Integer dormitory;

//    private Short position;
//    private String username;
//
//    private String password;
}
