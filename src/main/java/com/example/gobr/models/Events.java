package com.example.gobr.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String eventName;
    String eventTime;
    String eventUser;
    String eventEffect;

    public Events(String eventName, String eventTime, String eventUser, String eventEffect) {
        this.eventName = eventName;
        this.eventTime = eventTime;
        this.eventUser = eventUser;
        this.eventEffect = eventEffect;
    }
}
