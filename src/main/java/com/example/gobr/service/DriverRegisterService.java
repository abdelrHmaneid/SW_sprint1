package com.example.gobr.service;

import com.example.gobr.models.DriverProfile;
import com.example.gobr.repository.DriverRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverRegisterService {
    DriverRepos driverRepos;

    @Autowired
    public DriverRegisterService(DriverRepos driverRepos) {
        this.driverRepos = driverRepos;
    }

    public void Register(DriverProfile driverProfile){
        driverRepos.save(driverProfile);
    }
}
