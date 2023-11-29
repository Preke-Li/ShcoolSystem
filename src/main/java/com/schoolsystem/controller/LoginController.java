package com.schoolsystem.controller;

import com.schoolsystem.pojo.Account;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.pojo.Student;
import com.schoolsystem.service.LoginService;
import com.schoolsystem.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    public Result studentLogin(@RequestBody Account account){
        log.info("\n用户登录：\n输入的用户名和密码为：\n账号：{}\n密码：{}",account.getUsername(),account.getPassword());
        Account result=null;
        if(account.getPosition() == 1)
         result = loginService.studentLogin(account);
        else if (account.getPosition() == 0) {
            result = loginService.adminLogin(account);
        }
        log.info("查询到的用户信息为：{}",result);
        if(result!=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",result.getId());
            claims.put("username",result.getUsername());
            claims.put("name",result.getPosition());

            //生成JWT
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }else{
            return Result.error("登录失败，请检查账号密码");
        }
    }
}
