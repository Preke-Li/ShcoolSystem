package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.CardMapper;
import com.schoolsystem.dao.CardRechargeMapper;
import com.schoolsystem.dao.StudentMapper;
import com.schoolsystem.pojo.*;
import com.schoolsystem.dao.ClassMapper;
import com.schoolsystem.dao.StudentMapper;
import com.schoolsystem.pojo.Class;
import com.schoolsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    ClassMapper classMapper;

    @Autowired
    private CardRechargeMapper cardRechargeMapper;


    @Override
    public double getCardBalance(int studentId) {
        // 直接使用 studentId 查询 card 表
        Card card = cardMapper.getCardById(studentId);

        if (card != null) {
            return card.getBalance();
        }

        return 0.0;
    }

    public void rechargeCard(int studentId, BigDecimal amount) {
        Card card = cardMapper.getCardById(studentId);

        if (card != null) {
            BigDecimal currentBalance = BigDecimal.valueOf(card.getBalance());
            BigDecimal newBalance = currentBalance.add(amount);
            card.setBalance(newBalance.doubleValue()); // 将 BigDecimal 转换为 double

            cardMapper.updateCard(card);

            // 创建充值记录
            CardRecharge cardRecharge = new CardRecharge();
            cardRecharge.setStudentId(studentId);
            cardRecharge.setMoney(amount.doubleValue()); //
            cardRechargeMapper.insertCardRecharge(cardRecharge);
        } else {
            throw new IllegalArgumentException("无效的学生ID：" + studentId);
        }
    }





    @Override
    public List<CardRecharge> getCardTransactions(int studentId, String startDate, String endDate) {
        return cardRechargeMapper.getCardTransactions(studentId, startDate, endDate);
    }

    @Override
    public List<StudentBaseInfo> getStudentByClassId(Integer id) {
        return studentMapper.getStudentByClassId(id);
    }


    @Override
    public Student getInfoByUsername(String username) {
        return studentMapper.getInfoByUsername(username);
    }

    @Override
    public Student getInfoById(Integer id) {
        return studentMapper.getInfoById(id);
    }

    @Override
    public int updateStudent(String phone,String username,String avatar) {
        return studentMapper.updateStudent(phone,username,avatar);
    }

    @Override
    public int addStudent(Student student) {
        int result=studentMapper.addStudent(student);
        if (result>0){
            //获取原来班级的人数数据
            Class classInfo=classMapper.getByClassId(student.getClassId());
            Integer people=classInfo.getPeople()+1;
            //更新班级人数
            Class c=new Class();
            c.setId(student.getClassId());
            c.setPeople(people);
            classMapper.updateClass(c);
        }
        return result;
    }



}
