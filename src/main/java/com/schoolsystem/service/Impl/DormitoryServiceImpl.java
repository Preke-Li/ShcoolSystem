package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.CardMapper;
import com.schoolsystem.dao.CardRechargeMapper;
import com.schoolsystem.dao.DormitoryMapper;
import com.schoolsystem.dao.DormitoryRechargeMapper;
import com.schoolsystem.pojo.*;
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

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private CardRechargeMapper cardRechargeMapper;

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
    public void rechargeElectricity(int studentId, int dormitoryId, double amount) {
        Dormitory dormitory = dormitoryMapper.getDormitoryById(dormitoryId);

        if (dormitory != null) {
            // 更新电费余额
            double newBalance = dormitory.getElectricity() + amount;
            dormitory.setElectricity(newBalance);
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

    @Override
    public double getWaterBalance(int dormitoryId) {
        Dormitory dormitory = dormitoryMapper.getDormitoryById(dormitoryId);

        if (dormitory != null) {
            return dormitory.getWater();
        }

        return 0.0;
    }

    @Override
    @Transactional
    public void rechargeWater(int studentId, int dormitoryId, double amount) {
        Dormitory dormitory = dormitoryMapper.getDormitoryById(dormitoryId);

        if (dormitory != null) {
            // 更新水费余额
            double newBalance = dormitory.getWater() + amount;
            dormitory.setWater(newBalance);
            dormitoryMapper.updateDormitory1(dormitory);
        }
    }


    @Override
    public int addRepair(DormitoryRepair dormitoryRepair) {
        return dormitoryMapper.addRepair(dormitoryRepair);
    }

    @Override
    public List<Dormitory> selectAllDormitory() {
        return dormitoryMapper.selectAllDormitory();
    }

    @Override
    public Dormitory getDormitoryById(Integer id) {
        return dormitoryMapper.getDormitoryById(id);
    }


}
