package com.example.gobr.controller;

import com.example.gobr.models.Rides;
import com.example.gobr.service.OfferPriceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OfferPriceController {
    OfferPriceService offerPriceService;

    public OfferPriceController(OfferPriceService offerPriceService) {
        this.offerPriceService = offerPriceService;
    }

    @RequestMapping("/addOffer")
    public void addOffer(@RequestParam Map<String, String> Offer){
        String username = Offer.get("username");
        String source = Offer.get("source");
        String destination = Offer.get("destination");
        String price = Offer.get("price");
        Rides ride = new Rides(username,source,destination,"0");
        offerPriceService.addPrice(ride,price);
    }
}
