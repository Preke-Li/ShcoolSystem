package com.schoolsystem.service;

import com.schoolsystem.pojo.CardRecharge;
import com.schoolsystem.pojo.Student;
import com.schoolsystem.pojo.StudentBaseInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface StudentService {
    Student getInfoByUsername(String username);

    Student getInfoById(Integer id);

    int updateStudent(String phone,String username,String avatar);


    int addStudent(Student student);
    // 查询校园卡余额
    double getCardBalance(int studentId);

    // 校园卡充值
//    void rechargeCard(int studentId, double amount);


    List<CardRecharge> getCardTransactions(int studentId, String startDate, String endDate);

    List<StudentBaseInfo> getStudentByClassId(Integer id);

//    void rechargeCard(int studentId, String amount);

    void rechargeCard(int studentId, BigDecimal amount);
}
