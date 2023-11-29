package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.LoginMapper;
import com.schoolsystem.dao.StudentMapper;
import com.schoolsystem.pojo.Account;
import com.schoolsystem.pojo.Admin;
import com.schoolsystem.pojo.Student;
import com.schoolsystem.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public Student studentLogin(Account account) {
        return loginMapper.studentLogin(account);
    }

    @Override
    public Admin adminLogin(Account account) {
        return loginMapper.adminLogin(account);
    }
}
