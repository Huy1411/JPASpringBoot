package com.example.enterprise_application.jpa;


import com.example.enterprise_application.jpa.core.WareHouse;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    @Column(name = "streetAddress")
    private String streetAddress;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "stateProvine")
    private String stateProvine;

    @ManyToOne
    @JoinColumn(name = "countryId", referencedColumnName = "countryId")
    private Country country;

    @OneToOne(mappedBy = "location")
    private WareHouse wareHouse;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvine() {
        return stateProvine;
    }

    public void setStateProvine(String stateProvine) {
        this.stateProvine = stateProvine;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }
}
