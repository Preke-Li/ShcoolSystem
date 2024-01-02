package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.CardMapper;
import com.schoolsystem.dao.CardRechargeMapper;
import com.schoolsystem.dao.StudentMapper;
import com.schoolsystem.pojo.Card;
import com.schoolsystem.pojo.CardRecharge;
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

}
