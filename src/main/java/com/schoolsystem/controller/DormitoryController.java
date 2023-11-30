package com.schoolsystem.controller;

import com.schoolsystem.pojo.DormitoryRecharge;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    // 5.1 查询电费余额
    @GetMapping("/electricity/balance")
    public Result getElectricityBalance(@RequestParam int dormitoryId) {
        try {
            double balance = dormitoryService.getElectricityBalance(dormitoryId);
            return Result.success(balance);
        } catch (Exception e) {
            return Result.error("查询电费余额失败：" + e.getMessage());
        }
    }

    // 5.2 电费充值
    @PostMapping("/electricity/recharge")
    public Result rechargeElectricity(@RequestBody Map<String, Object> requestData) {
        try {
            Integer studentIdObj = (Integer) requestData.get("studentId");
            Integer dormitoryIdObj = (Integer) requestData.get("dormitoryId");
            Integer amountObj = (Integer) requestData.get("amount");

            if (studentIdObj != null && dormitoryIdObj != null && amountObj != null) {
                int studentId = studentIdObj.intValue();
                int dormitoryId = dormitoryIdObj.intValue();
                int amount = amountObj.intValue();

                dormitoryService.rechargeElectricity(studentId, dormitoryId, amount);
                return Result.success("电费充值成功");
            } else {
                return Result.error("请求参数缺失或格式不正确");
            }
        } catch (Exception e) {
            return Result.error("电费充值失败：" + e.getMessage());
        }
    }

    @GetMapping("/electricity/recharge/history")
    public Result getRechargeHistory(@RequestParam int dormitoryId) {
        try {
            // 调用 Service 层方法获取充值记录
            List<DormitoryRecharge> rechargeHistory = dormitoryService.getRechargeHistory(dormitoryId);
            return Result.success(rechargeHistory);
        } catch (Exception e) {
            return Result.error("查询充值记录失败：" + e.getMessage());
        }
    }
}
