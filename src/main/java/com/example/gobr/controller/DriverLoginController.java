package com.example.gobr.controller;
import com.example.gobr.service.LoginDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class DriverLoginController {
    LoginDriverService loginDriverService;

    @Autowired
    public DriverLoginController(LoginDriverService loginDriverService) {
        this.loginDriverService = loginDriverService;
    }
    @RequestMapping("/Dlogin")
    public void driverLogin(@RequestParam Map<String, String> Driver) {
        String DriverName = Driver.get("username");
        String DriverPass = Driver.get("password");
        loginDriverService.login(DriverName,DriverPass);
    }
}
