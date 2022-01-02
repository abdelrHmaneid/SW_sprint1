package com.example.gobr.controller;

import com.example.gobr.repository.DriverRepos;
import com.example.gobr.service.CalcDriverRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CalcRateController {
    CalcDriverRateService calcDriverRateService;
    DriverRepos driverRepos;

    @Autowired
    public CalcRateController(CalcDriverRateService calcDriverRateService, DriverRepos driverRepos) {
        this.calcDriverRateService = calcDriverRateService;
        this.driverRepos = driverRepos;
    }

    @RequestMapping("/SeeRate")
    public void calcRate(@RequestParam Map<String, String> Calc){
        String username = Calc.get("DriverName");
        calcDriverRateService.calcRate(driverRepos.getById(username));
    }
}
