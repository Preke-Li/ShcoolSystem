package com.schoolsystem.controller;

import com.schoolsystem.pojo.Result;
import com.schoolsystem.pojo.Student;
import com.schoolsystem.service.ClassService;
import com.schoolsystem.service.MajorService;
import com.schoolsystem.service.StudentService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @Autowired
    MajorService majorService;

    @GetMapping("/student")
    public Result getStudentInfo(@NotNull @NotBlank String username){
        Student s=studentService.getInfoByUsername(username);
        if(s == null){
            return Result.error("该用户不存在");
        }else{
            Map<String,Object> result=new HashMap<>();
            result.put("name",s.getName());
            result.put("sex",s.getSex());
            result.put("phone",s.getPhone());
            result.put("username",s.getUsername());
            result.put("major",majorService.getName(s.getMajorId()));
            result.put("position",s.getPosition());
            result.put("dormitoryId",s.getDormitoryId());
            result.put("avatar",s.getAvatar());
            return Result.success(result);
        }
    }
    @PutMapping("student")
    public Result updateStudentPhone(@NotNull @NotBlank @Size(min=11,max=11) @RequestParam("phone") String phone, @RequestParam("username") String username,@RequestParam("avatar") String avatar){
        if (studentService.updateStudent(phone,username,avatar)>0){
            return Result.success("修改成功");
        }else{
            return Result.error("修改失败");
        }

    }

    @PostMapping("/student")
    public Result addStudent(@RequestBody Student student){
        if(studentService.addStudent(student)>0) {
            return Result.success("添加学生信息成功");
        }else {
            return  Result.error("添加学生失败，请检出输入的参数");
        }
    }
}
