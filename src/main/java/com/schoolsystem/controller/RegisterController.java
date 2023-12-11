package com.schoolsystem.controller;

import com.schoolsystem.pojo.Account;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegisterController {

/*    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public Result registerUser(@RequestBody Account account){
        log.info("\n传入的注册参数为：\n{}\n",account);
        if(account.getPosition() ==0 ){
            return Result.error("无法注册管理员用户！！！！");
        }
        if(registerService.addUser(account)>0){
            return Result.success("插入成功");
        }else {
            return Result.error("插入失败，用户名已存在或输入不合法");
        }
    }*/
}
