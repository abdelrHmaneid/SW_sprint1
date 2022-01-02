package com.example.gobr.service;

import com.example.gobr.models.Rates;
import com.example.gobr.repository.RateRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateDriverService {
    RateRepos rateRepos;

    @Autowired
    public RateDriverService(RateRepos rateRepos) {
        this.rateRepos = rateRepos;
    }

    public void rate(Rates rate){
        rateRepos.save(rate);
    }
}
