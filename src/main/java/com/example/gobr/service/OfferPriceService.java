package com.example.gobr.service;

import com.example.gobr.models.Rides;
import com.example.gobr.repository.RideRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferPriceService {
    RideRepos rideRepos;

    @Autowired
    public OfferPriceService(RideRepos rideRepos) {
        this.rideRepos = rideRepos;
    }

    public void addPrice(Rides rides, String price){
        if(rideRepos.existsById(rides.getUsername())){
            rides.setPrice(price);
        }
    }
}
