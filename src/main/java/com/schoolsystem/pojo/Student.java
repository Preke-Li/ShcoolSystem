package com.schoolsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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

    // Getter method for dormitory
    public Integer getDormitoryId() {
        return dormitoryId;
    }

//    private Short position;
//    private String username;
//
//    private String password;
}
