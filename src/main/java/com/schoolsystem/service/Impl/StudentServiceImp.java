package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.CardMapper;
import com.schoolsystem.dao.CardRechargeMapper;
import com.schoolsystem.dao.StudentMapper;
import com.schoolsystem.pojo.Card;
import com.schoolsystem.pojo.CardRecharge;
import com.schoolsystem.dao.ClassMapper;
import com.schoolsystem.dao.StudentMapper;
import com.schoolsystem.pojo.Class;
import com.schoolsystem.pojo.Student;
import com.schoolsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            return Double.parseDouble(card.getBalance());
        }

        return 0.0;
    }

    @Override
    @Transactional
    public void rechargeCard(int studentId, int amount) {
        Card card = cardMapper.getCardById(studentId);

        if (card != null) {
            double currentBalance = Double.parseDouble(card.getBalance());
            double newBalance = currentBalance + amount;

            if (newBalance >= 0) {
                // 更新卡的余额
                card.setBalance(String.valueOf(newBalance));
                cardMapper.updateCard(card);

                // 创建充值记录
                CardRecharge cardRecharge = new CardRecharge();
                cardRecharge.setStudentId(studentId);
                cardRecharge.setMoney(amount);
                cardRechargeMapper.insertCardRecharge(cardRecharge);
            } else {
                throw new RuntimeException("余额不足，充值失败");
            }
        } else {
            throw new RuntimeException("卡不存在，充值失败");
        }
    }

    @Override
    public List<CardRecharge> getCardTransactions(int studentId) {
        return cardRechargeMapper.getCardTransactions(studentId);
    }

    @Override
    public Student getInfoByUsername(String username) {
        return studentMapper.getInfoByUsername(username);
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
