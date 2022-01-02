package com.example.gobr.controller;

import com.example.gobr.service.AddDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddDiscountController {
    AddDiscountService addDiscountService;

    @Autowired
    public AddDiscountController(AddDiscountService addDiscountService) {
        this.addDiscountService = addDiscountService;
    }

    @RequestMapping("/discountByArea")
    public void discountArea(@RequestParam Map<String,String> Discount){
        String destination = Discount.get("discount");
        addDiscountService.discountByArea(destination);
    }

    @RequestMapping("/discountByPassengers")
    public void discountPassengers(@RequestParam Map<String,String> Discount){
        String num = Discount.get("numberOfPassengers");
        addDiscountService.discountByPassengerNum(Integer.parseInt(num));
    }
}
