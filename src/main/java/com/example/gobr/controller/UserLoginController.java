package com.example.gobr.controller;

import com.example.gobr.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class UserLoginController {
    LoginUserService loginUserService;

    @Autowired
    public UserLoginController(LoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }

    @RequestMapping("/Ulogin")
    public void userLogin(@RequestParam Map<String, String> User){
        String username = User.get("username");
        String password = User.get("password");
        loginUserService.login(username,password);
    }
}
