package com.example.gobr.service;

import com.example.gobr.models.Rides;
import com.example.gobr.repository.RideRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddDiscountService {
    RideRepos rideRepos;

    @Autowired
    public AddDiscountService(RideRepos rideRepos) {
        this.rideRepos = rideRepos;
    }

    public void discountByArea(String destination){
        List<Rides> L_rides = rideRepos.getAllByDestination(destination);
        for (Rides l_ride : L_rides) {
            l_ride.setPrice(l_ride.getPrice() * 0.9);
        }
    }

    public void discountByPassengerNum(int num){
        List<Rides> L_rides = rideRepos.getAllByNumberOfPassengers(num);
        for (Rides l_ride : L_rides) {
            l_ride.setPrice(l_ride.getPrice() * 0.95);
        }
    }
}
