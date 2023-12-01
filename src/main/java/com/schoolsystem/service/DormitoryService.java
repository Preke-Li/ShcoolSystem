package com.schoolsystem.service;

import com.schoolsystem.pojo.DormitoryRecharge;

import java.util.List;

public interface DormitoryService {

    // 查询电费余额
    double getElectricityBalance(int dormitoryId);

    // 电费充值
    void rechargeElectricity(int studentId, int dormitoryId, int amount);

    List<DormitoryRecharge> getRechargeHistory(int dormitoryId);

    double getWaterBalance(int dormitoryId);

    void rechargeWater(int studentId, int dormitoryId, int amount);
}
