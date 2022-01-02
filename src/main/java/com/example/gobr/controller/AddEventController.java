package com.example.gobr.controller;

import com.example.gobr.models.Events;
import com.example.gobr.service.AddEventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddEventController {
    AddEventServices addEventServices;

    @Autowired
    public AddEventController(AddEventServices addEventServices) {
        this.addEventServices = addEventServices;
    }

    @RequestMapping
    public void AddEvent(@RequestParam Map<String , String> Event){
        String eventName = Event.get("EventName");
        String eventTime = Event.get("EventTime");
        String eventUser = Event.get("EventUser");
        String eventEffect = Event.get("EventEffect");
        Events event = new Events(eventName,eventTime,eventUser,eventEffect);
        addEventServices.Add(event);
    }
}
