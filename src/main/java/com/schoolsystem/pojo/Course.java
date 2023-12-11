package com.schoolsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer id;
    private String name;
    private Integer beginWeek;
    private Integer endWeek;
    private Short day;
    private Short period;
    private String classroom;
}
