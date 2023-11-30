package com.schoolsystem.service;

public interface StudentService {

    // 查询校园卡余额
    double getCardBalance(int studentId);

    // 校园卡充值
    void rechargeCard(int studentId, int amount);
}
