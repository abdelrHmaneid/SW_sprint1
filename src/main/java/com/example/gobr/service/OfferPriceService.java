package com.example.gobr.service;

import com.example.gobr.models.Rides;
import com.example.gobr.repository.DriverRepos;
import com.example.gobr.repository.RideRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferPriceService {
    RideRepos rideRepos;
    DriverRepos driverRepos;

    @Autowired
    public OfferPriceService(RideRepos rideRepos) {
        this.rideRepos = rideRepos;
    }

    public void addPrice(Rides rides, String price ,String driverName){
        if(rideRepos.existsById(rides.getId())){
            rides.setPrice(price);
        }
        driverRepos.getById(driverName).setAvailable(1);
    }

}
