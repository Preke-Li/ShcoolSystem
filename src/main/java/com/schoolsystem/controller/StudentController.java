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
import com.schoolsystem.pojo.CardRecharge;
import com.schoolsystem.service.StudentService;



import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @Autowired
    MajorService majorService;

    @GetMapping("/info")
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
    @PutMapping("/update")

    public Result updateStudentPhone(@NotNull @NotBlank @Size(min=11,max=11) @RequestParam("phone") String phone, @RequestParam("username") String username,@RequestParam("avatar") String avatar){
        if (studentService.updateStudent(phone,username,avatar)>0){
            return Result.success("修改成功");
        }else{
            return Result.error("修改失败");
        }

    }

    @PostMapping("/add")
    public Result addStudent(@RequestBody Student student){
        if(studentService.addStudent(student)>0) {
            return Result.success("添加学生信息成功");
        }else {
            return  Result.error("添加学生失败，请检出输入的参数");
        }
    }

    // 4.1 查询校园卡余额
    @GetMapping("/card/balance")
    public Result getCardBalance(@RequestParam int studentId) {
        try {
            // 调用 Service 层方法获取校园卡余额
            double balance = studentService.getCardBalance(studentId);
            return Result.success(balance);
        } catch (Exception e) {
            return Result.error("查询校园卡余额失败：" + e.getMessage());
        }
    }


    // 4.2 校园卡充值
    @PostMapping("/card/recharge")
    public Result rechargeCard(@RequestBody Map<String, Integer> requestData) {
        try {
            int studentId = requestData.get("studentId");
            int amount = requestData.get("amount");
            // 调用 Service 层方法进行校园卡充值
            studentService.rechargeCard(studentId, amount);
            return Result.success("校园卡充值成功");
        } catch (Exception e) {
            return Result.error("校园卡充值失败：" + e.getMessage());
        }
    }

    // 4.3 查询校园卡交易记录
    @GetMapping("/card/transactions")
    public Result getCardTransactions(@RequestParam int studentId) {
        try {
            // 调用 Service 层方法获取校园卡交易记录
            List<CardRecharge> transactions = studentService.getCardTransactions(studentId);
            return Result.success(transactions);
        } catch (Exception e) {
            return Result.error("查询校园卡交易记录失败：" + e.getMessage());
        }
    }
}
