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
public class FavArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String driverName;
    String favArea;

    public FavArea(String driverName, String favArea) {
        this.driverName = driverName;
        this.favArea = favArea;
    }
}
