package com.example.gobr.service;

import com.example.gobr.models.DriverProfile;
import com.example.gobr.repository.DriverRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyDriverService {
    DriverRepos driverRepos;

    @Autowired
    public VerifyDriverService(DriverRepos driverRepos) {
        this.driverRepos = driverRepos;
    }

    public void verifyDriver(String username){
        if(driverRepos.existsById(username)){
            DriverProfile driverProfile = driverRepos.getById(username);
            driverProfile.setState("1");
        }
    }

}
