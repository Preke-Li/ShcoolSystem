package com.schoolsystem.service;

import com.schoolsystem.pojo.CardRecharge;
import com.schoolsystem.pojo.Student;

import java.util.List;

public interface StudentService {
    Student getInfoByUsername(String username);

    int updateStudent(String phone,String username,String avatar);


    int addStudent(Student student);
    // 查询校园卡余额
    double getCardBalance(int studentId);

    // 校园卡充值
    void rechargeCard(int studentId, int amount);


    List<CardRecharge> getCardTransactions(int studentId, String startDate, String endDate);

}
