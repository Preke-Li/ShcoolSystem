package com.schoolsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DormitoryRepair {

    private Integer id;
    private Integer studentId;
    private Integer repairType;
    private String description;
    private Integer dormitoryId;

    private String phone;
}
