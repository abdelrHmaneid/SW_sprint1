package com.example.gobr.controller;

import com.example.gobr.models.Rates;
import com.example.gobr.service.RateDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RateDriverController {
    RateDriverService rateDriverService;

    @Autowired
    public RateDriverController(RateDriverService rateDriverService) {
        this.rateDriverService = rateDriverService;
    }

    @RequestMapping("/rate")
    public void rateDriver(@RequestParam Map<String,String> Rate){
        String username = Rate.get("username");
        String rate = Rate.get("rate");
        String DriverName = Rate.get("DriverName");
        Rates rate1 = new Rates(username,Integer.parseInt(rate),DriverName);
        rateDriverService.rate(rate1);
    }
}
