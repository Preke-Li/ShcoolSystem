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
        // 直接使用 studentId 查询 card 表
        Card card = cardMapper.getCardById(studentId);

        if (card != null) {
            // 更新卡的余额
            double newBalance = Double.parseDouble(card.getBalance()) + amount;
            card.setBalance(String.valueOf(newBalance));
            cardMapper.updateCard(card);
        }

    }
}
