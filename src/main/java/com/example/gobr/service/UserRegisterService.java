package com.example.gobr.service;

import com.example.gobr.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gobr.repository.UserRepos;

@Service
public class UserRegisterService {
    UserRepos userRepos;

    @Autowired
    public UserRegisterService(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    public void Register(UserProfile userProfile){
        userRepos.save(userProfile);
    }
}
