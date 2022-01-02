package com.example.gobr.controller;

import com.example.gobr.models.Rides;
import com.example.gobr.service.RequestRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class RequestRideController {
    RequestRideService requestRideService;

    @Autowired
    public RequestRideController(RequestRideService requestRideService) {
        this.requestRideService = requestRideService;
    }

    @RequestMapping("/requestRide")
    public void requestRide(@RequestParam Map<String, String> Ride){
        String username = Ride.get("username");
        String source = Ride.get("source");
        String destination = Ride.get("destination");
        Rides ride = new Rides(username,source,destination,"0");
        requestRideService.request(ride);
    }
}
