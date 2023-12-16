package com.schoolsystem.service.Impl;


import com.schoolsystem.dao.BalanceMapper;
import com.schoolsystem.pojo.Balance;
import com.schoolsystem.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BalanceServiceImpl implements BalanceService {
    @Autowired
    private BalanceMapper balanceMapper;

    @Override
    public List<Balance> getDailyBalances(int dormitoryId) {
        return balanceMapper.getDailyBalances(dormitoryId);
    }
}
