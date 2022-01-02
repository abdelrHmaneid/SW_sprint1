package com.example.gobr.controller;

import com.example.gobr.models.FavArea;
import com.example.gobr.service.AddFavAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddFavAreaController {
    AddFavAreaService addFavAreaService;

    @Autowired
    public AddFavAreaController(AddFavAreaService addFavAreaService) {
        this.addFavAreaService = addFavAreaService;
    }

    @RequestMapping("/AddFavArea")
    public void addFavArea(@RequestParam Map<String, String> Area){
        String driverName = Area.get("driverName");
        String area = Area.get("favArea");
        FavArea favArea = new FavArea(driverName,area);
        addFavAreaService.Add(favArea);
    }
}
