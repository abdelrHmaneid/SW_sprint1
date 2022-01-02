package com.example.gobr.service;

import com.example.gobr.models.Rides;
import com.example.gobr.repository.RideRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddDiscountByAreaService {
    RideRepos rideRepos;

    @Autowired
    public AddDiscountByAreaService(RideRepos rideRepos) {
        this.rideRepos = rideRepos;
    }

    public void discount(String destination){
        List<Rides> L_rides = rideRepos.getAllByDestination(destination);
        for(int i = 0 ; i<L_rides.size() ;i++){
            L_rides.get(i).setPrice(L_rides.get(i).getPrice()*0.9);
        }
    }
}
