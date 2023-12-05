package com.schoolsystem.pojo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dormitory {
    private Integer id;

    private Integer electricity;

    private Integer water;
}
