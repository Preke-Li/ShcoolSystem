package com.schoolsystem.controller;

import com.schoolsystem.pojo.*;
import com.schoolsystem.service.DormitoryService;
import com.schoolsystem.service.BalanceService;
import com.schoolsystem.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private BalanceService balanceService;

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

    @PostMapping("/electricity/recharge")
    public Result rechargeElectricity(@RequestBody Map<String, Object> requestData) {
        try {
            Integer studentIdObj = (Integer) requestData.get("studentId");
            Integer dormitoryIdObj = (Integer) requestData.get("dormitoryId");
            Double amountObj = (Double) requestData.get("amount");

            if (studentIdObj != null && dormitoryIdObj != null && amountObj != null) {
                int studentId = studentIdObj.intValue();
                int dormitoryId = dormitoryIdObj.intValue();
                double amount = amountObj;

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
            List<DormitoryRecharge> rechargeHistory = dormitoryService.getRechargeHistory(dormitoryId);
            return Result.success(rechargeHistory);
        } catch (Exception e) {
            return Result.error("查询充值记录失败：" + e.getMessage());
        }
    }

    @GetMapping("/water/balance")
    public Result getWaterBalance(@RequestParam int dormitoryId) {
        try {
            double balance = dormitoryService.getWaterBalance(dormitoryId);
            return Result.success(balance);
        } catch (Exception e) {
            return Result.error("查询水费余额失败：" + e.getMessage());
        }
    }

    @PostMapping("/water/recharge")
    public Result rechargeWater(@RequestBody Map<String, Object> requestData) {
        try {
            Integer studentIdObj = (Integer) requestData.get("studentId");
            Integer dormitoryIdObj = (Integer) requestData.get("dormitoryId");
            Double amountObj = (Double) requestData.get("amount");

            if (studentIdObj != null && dormitoryIdObj != null && amountObj != null) {
                int studentId = studentIdObj.intValue();
                int dormitoryId = dormitoryIdObj.intValue();
                double amount = amountObj;

                dormitoryService.rechargeWater(studentId, dormitoryId, amount);
                return Result.success("水费充值成功");
            } else {
                return Result.error("请求参数缺失或格式不正确");
            }
        } catch (Exception e) {
            return Result.error("水费充值失败：" + e.getMessage());
        }
    }

    @GetMapping("/dailyBalances")
    public Result getDailyBalances(@RequestParam int dormitoryId) {
        try {
            List<Balance> dailyBalances = balanceService.getDailyBalances(dormitoryId);
            return Result.success(dailyBalances);
        } catch (Exception e) {
            return Result.error("查询每日余额失败：" + e.getMessage());
        }
    }



    @PostMapping("/dormitoryRepair")
    public Result commitRepair(@RequestBody DormitoryRepair dormitoryRepair) {
        if (dormitoryService.addRepair(dormitoryRepair)>0)
            return Result.success("提交保修成功");
        else
            return Result.error("保修失败");
    }

    @GetMapping("/getDormitory")
    public Result getDormitoryById( Integer id){
        Dormitory dormitoriy = dormitoryService.getDormitoryById(id);
        if(dormitoriy != null){
            return Result.success(dormitoriy);
        }
        return Result.error("输入的宿舍号错误或者宿舍不存在！！！");
    }
}
