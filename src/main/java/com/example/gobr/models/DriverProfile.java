package com.example.gobr.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DriverProfile {
    @Id
    String DriverName;
    String DriverPassword;
    String DriverPhone;
    String DriverEmail;
    String nationalID;
    String license;
    String state;
}
