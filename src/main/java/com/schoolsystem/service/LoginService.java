package com.schoolsystem.service;

import com.schoolsystem.pojo.Account;
import com.schoolsystem.pojo.Admin;
import com.schoolsystem.pojo.Student;

public interface LoginService {
    Student studentLogin(Account account);

    Admin adminLogin(Account account);
}
