package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.DormitoryMapper;
import com.schoolsystem.dao.DormitoryRechargeMapper;
import com.schoolsystem.pojo.Dormitory;
import com.schoolsystem.pojo.DormitoryRecharge;
import com.schoolsystem.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private DormitoryRechargeMapper dormitoryRechargeMapper;

    @Override
    public double getElectricityBalance(int dormitoryId) {
        Dormitory dormitory = dormitoryMapper.getDormitoryById(dormitoryId);

        if (dormitory != null) {
            return dormitory.getElectricity();
        }

        return 0.0;
    }

    @Override
    @Transactional
    public void rechargeElectricity(int studentId, int dormitoryId, int amount) {
        Dormitory dormitory = dormitoryMapper.getDormitoryById(dormitoryId);

        if (dormitory != null) {
            // 更新电费余额
            double newBalance = dormitory.getElectricity() + amount;
            dormitory.setElectricity((int) newBalance);
            dormitoryMapper.updateDormitory(dormitory);

            // 记录充值信息
            DormitoryRecharge rechargeRecord = new DormitoryRecharge();
            rechargeRecord.setDormitoryId(dormitoryId);
            rechargeRecord.setAmount(amount);
            rechargeRecord.setStudentId(studentId);
            dormitoryRechargeMapper.insertDormitoryRecharge(rechargeRecord);
        }
    }

    @Override
    public List<DormitoryRecharge> getRechargeHistory(int dormitoryId) {
        // 实现获取充值记录的逻辑，调用相应的数据库查询方法
        return dormitoryRechargeMapper.getRechargeHistoryByDormitoryId(dormitoryId);
    }

}
