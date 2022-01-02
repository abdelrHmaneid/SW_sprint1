package com.example.gobr.controller;

import com.example.gobr.service.AddDiscountByAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddDiscountByAreaController {
    AddDiscountByAreaService addDiscountByAreaService;

    @Autowired
    public AddDiscountByAreaController(AddDiscountByAreaService addDiscountByAreaService) {
        this.addDiscountByAreaService = addDiscountByAreaService;
    }

    @RequestMapping("/discount")
    public void discount(@RequestParam Map<String,String> Discount){
        String destination = Discount.get("discount");
        addDiscountByAreaService.discount(destination);
    }
}
