package com.example.enterprise_application.jpa.core;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "streetAddress")
    private String streetAddress;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "stateProvine")
    private String stateProvine;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;

    @OneToOne(mappedBy = "location")
    private WareHouse wareHouse;

    public Location(String streetAddress, String postalCode, String city, String stateProvine, Country country, WareHouse wareHouse) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvine = stateProvine;
        this.country = country;
        this.wareHouse = wareHouse;
    }
}
