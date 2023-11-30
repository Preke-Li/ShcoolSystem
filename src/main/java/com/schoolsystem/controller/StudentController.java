package com.schoolsystem.controller;

import com.schoolsystem.pojo.Result;
import com.schoolsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/student/card")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 4.1 查询校园卡余额
    @GetMapping("/balance")
    public Result getCardBalance(@RequestBody Map<String, Integer> requestData) {
        try {
            int studentId = requestData.get("studentId");
            // 调用 Service 层方法获取校园卡余额
            double balance = studentService.getCardBalance(studentId);
            return Result.success(balance);
        } catch (Exception e) {
            return Result.error("查询校园卡余额失败：" + e.getMessage());
        }
    }

    // 4.2 校园卡充值
    @PostMapping("/recharge")
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
}
