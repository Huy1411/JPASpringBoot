package com.example.enterprise_application.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class WareHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wareHoseId;

    @Column(name = "wareHouseSpec")
    private String wareHouseSpec;

    @Column(name = "wareHouseName")
    private String wareHouseName;

    @Column(name = "whGeoLocation")
    private String whGeoLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationId", referencedColumnName = "locationId")
    private Location location;

    @OneToMany(mappedBy = "wareHouse", cascade = CascadeType.ALL)
    private Set<Inventory> inventory = new HashSet<>();

    public WareHouse(String wareHouseSpec, String wareHouseName, String whGeoLocation, Location location) {
        this.wareHouseSpec = wareHouseSpec;
        this.wareHouseName = wareHouseName;
        this.whGeoLocation = whGeoLocation;
        this.location = location;
    }
}
