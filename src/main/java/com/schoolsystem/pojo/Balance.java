package com.schoolsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Balance {

    private int dormitoryId;
    private String date;
    private double electricity;
    private double water;

    // getters and setters
}
