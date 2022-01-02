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
public class Rides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String source;
    String destination;
    String price;

    public Rides(String username, String source, String destination, String price) {
        this.username = username;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }
}
