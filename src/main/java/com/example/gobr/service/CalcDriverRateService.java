package com.example.gobr.service;

import com.example.gobr.models.DriverProfile;
import com.example.gobr.models.Rates;
import com.example.gobr.repository.DriverRepos;
import com.example.gobr.repository.RateRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcDriverRateService {
    DriverRepos driverRepos;
    RateRepos rateRepos;

    @Autowired
    public CalcDriverRateService(DriverRepos driverRepos) {
        this.driverRepos = driverRepos;
    }

    public void calcRate(DriverProfile driverProfile){
        double avgRate =0;
        List<Rates> rates= rateRepos.getAllByDriverName(driverProfile.getDriverName());
        for (Rates rate : rates) {
            avgRate += rate.getRate();
        }
        avgRate /= rates.size();
        driverProfile.setRate(avgRate);
    }
}
