package com.example.gobr.service;
import com.example.gobr.models.DriverProfile;
import com.example.gobr.repository.DriverRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginDriverService {
    DriverRepos driverRepos;

    @Autowired
    public LoginDriverService(DriverRepos driverRepos) {
        this.driverRepos = driverRepos;
    }

    public void login(String username, String password){
        if(driverRepos.existsById(username)){
            DriverProfile driverProfile = driverRepos.getById(username);
            if(driverProfile.getDriverPassword()==password&&driverProfile.getState()=="1"){
                System.out.println("login successfully");
            }
        }
        else {
            System.out.println("invalid username/password");
        }
    }
}
