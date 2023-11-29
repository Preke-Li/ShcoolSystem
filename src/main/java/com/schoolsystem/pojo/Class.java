package com.schoolsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    private Integer id;
    private String className;
    private Integer people;
    private Integer majorId;
    private Integer monitorId;
}
