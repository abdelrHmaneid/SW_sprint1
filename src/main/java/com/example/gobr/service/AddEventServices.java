package com.example.gobr.service;

import com.example.gobr.models.Events;
import com.example.gobr.repository.EventRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddEventServices {
    EventRepos eventRepos;

    @Autowired
    public AddEventServices(EventRepos eventRepos) {
        this.eventRepos = eventRepos;
    }

    public void Add(Events event){
        eventRepos.save(event);
    }
}
