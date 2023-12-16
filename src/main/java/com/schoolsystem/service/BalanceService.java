package com.schoolsystem.service;

import com.schoolsystem.pojo.Balance;
import java.util.List;
public interface BalanceService {


     List<Balance> getDailyBalances(int dormitoryId);
}
