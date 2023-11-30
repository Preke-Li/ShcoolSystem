package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.CardMapper;
import com.schoolsystem.dao.StudentMapper;
import com.schoolsystem.pojo.Card;
import com.schoolsystem.pojo.Student;
import com.schoolsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CardMapper cardMapper;

    @Override
    public double getCardBalance(int studentId) {
        // 假设通过 studentId 存在 Student 和 Card 之间的关联关系
        Student student = studentMapper.getStudentById(studentId);
        if (student != null && student.getDormitoryId() != null) {
            Card card = cardMapper.getCardById(student.getDormitoryId());
            if (card != null) {
                return Double.parseDouble(card.getBalance());
            }
        }
        return 0.0; // 如果未找到卡或学生，返回 0
    }

    @Override
    @Transactional
    public void rechargeCard(int studentId, int amount) {
        // 通过 studentId 存在 Student 和 Card 之间的关联关系
        Student student = studentMapper.getStudentById(studentId);
        if (student != null && student.getDormitoryId() != null) {
            Card card = cardMapper.getCardById(student.getDormitoryId());
            if (card != null) {
                // 更新卡的余额
                double newBalance = Double.parseDouble(card.getBalance()) + amount;
                card.setBalance(String.valueOf(newBalance));
                cardMapper.updateCard(card);
            }
        }

    }
}
