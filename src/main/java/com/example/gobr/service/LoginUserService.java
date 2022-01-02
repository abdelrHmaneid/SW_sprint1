package com.example.gobr.service;

import com.example.gobr.models.DriverProfile;
import com.example.gobr.models.UserProfile;
import com.example.gobr.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginUserService {
    UserRepos userRepos;

    @Autowired
    public LoginUserService(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    public void login(String username, String password){
        if(userRepos.existsById(username)){
            UserProfile userProfile = userRepos.getById(username);
            if(userProfile.getUserPassword()==password){
                System.out.println("login successfully");
            }
        }
        else {
            System.out.println("invalid username/password");
        }
    }
}
