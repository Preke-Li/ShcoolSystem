package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.RegisterMapper;
import com.schoolsystem.pojo.Account;
import com.schoolsystem.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImp implements RegisterService {
    @Autowired
    RegisterMapper registerMapper;

    @Override
    public int addUser(Account account) {

        if (registerMapper.selectExistAccount(account) == null) {
            return registerMapper.addUser(account);
        } else {
            return 0;
        }
    }
}
