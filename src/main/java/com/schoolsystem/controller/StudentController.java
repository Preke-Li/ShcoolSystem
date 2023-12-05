package com.schoolsystem.controller;

import com.schoolsystem.pojo.Result;
import com.schoolsystem.pojo.Student;
import com.schoolsystem.service.ClassService;
import com.schoolsystem.service.StudentService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @GetMapping("/student")
    public Result getStudentInfo(@NotNull @NotBlank String username){
        Student s=studentService.getInfoByUsername(username);
        if(s == null){
            return Result.error("账号不存在");
        }else{
            Map<String,Object> result=new HashMap<>();
            result.put("classInfo",classService.getByClassId(s.getClassId()));
            result.put("studentInfo",s);
            return Result.success(result);
        }
    }
}
