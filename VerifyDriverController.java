package com.example.gobr.controller;

import com.example.gobr.service.VerifyDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class VerifyDriverController {
    VerifyDriverService verifyDriverService;

    @Autowired
    public VerifyDriverController(VerifyDriverService verifyDriverService) {
        this.verifyDriverService = verifyDriverService;
    }

    @RequestMapping("/Verify")
    public void verify(@RequestParam Map<String, String> Driver){
        String username = Driver.get("DriverName");
        verifyDriverService.verifyDriver(username);
    }
}
