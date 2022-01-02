package com.example.gobr.controller;

import com.example.gobr.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.gobr.service.UserRegisterService;

import java.util.Map;

@RestController
public class UserRegisterController {
    UserRegisterService userRegisterService;

    @Autowired
    public UserRegisterController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @RequestMapping("/UserRegistry")
    public void RegisterControl(@RequestParam Map<String, String> User){
        String UserName = User.get("username");
        String UserPass = User.get("password");
        String UserPhone = User.get("phone");
        String UserEmail = User.get("email");
        UserProfile userProfile = new UserProfile(UserName,UserPass,UserPhone,UserEmail);
        userRegisterService.Register(userProfile);
    }
}
