package com.example.gobr.service;

import com.example.gobr.models.Rides;
import com.example.gobr.repository.RideRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestRideService {
    RideRepos rideRepos;

    @Autowired
    public RequestRideService(RideRepos rideRepos) {
        this.rideRepos = rideRepos;
    }

    public void request(Rides rides){
        rideRepos.save(rides);
    }
}
