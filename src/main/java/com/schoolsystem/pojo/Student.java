package com.schoolsystem.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
public class Student extends Account{
//    private Integer id;
    private String name;
    private String phone;

    private Integer majorId;


    private Integer classId;

    private Integer dormitoryId;

    private Short sex;

    private String avatar;

//    private Short position;
//    private String username;
//
//    private String password;
}
