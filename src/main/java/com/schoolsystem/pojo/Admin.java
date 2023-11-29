package com.schoolsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Admin extends Account{
//    private Integer id;
    private String name;
    private String phone;


//    private String position;
//    private String username;
//    private String password;
}
