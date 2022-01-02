package com.example.gobr.controller;

import com.example.gobr.models.DriverProfile;
import com.example.gobr.service.DriverRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DriverRegisterController {
    DriverRegisterService driverRegisterService;

    @Autowired
    public DriverRegisterController(DriverRegisterService driverRegisterService) {
        this.driverRegisterService = driverRegisterService;
    }

    @RequestMapping("/DriverRegistry")
    public void RegisterControl(@RequestParam Map<String, String> Driver){
        String DriverName = Driver.get("username");
        String DriverPass = Driver.get("password");
        String DriverPhone = Driver.get("phone");
        String DriverEmail = Driver.get("email");
        String nationalID = Driver.get("nationalID");
        String license = Driver.get("licence");
        DriverProfile driverProfile = new DriverProfile(DriverName,DriverPass,DriverPhone,DriverEmail,nationalID,license,"0",0);
        driverRegisterService.Register(driverProfile);
    }
}
