package com.schoolsystem.controller;

import com.schoolsystem.pojo.CardRecharge;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

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
