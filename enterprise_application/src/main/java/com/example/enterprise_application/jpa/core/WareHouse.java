package com.example.enterprise_application.jpa.core;

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
    private int id;

    @Column(name = "spec")
    private String spec;

    @Column(name = "name")
    private String name;

    @Column(name = "geoLocation")
    private String geoLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationId", referencedColumnName = "id")
    private Location location;

    @OneToMany(mappedBy = "wareHouse", cascade = CascadeType.ALL)
    private Set<Inventory> inventory = new HashSet<>();

    public WareHouse(String spec, String name, String geoLocation, Location location) {
        this.spec = spec;
        this.name = name;
        this.geoLocation = geoLocation;
        this.location = location;
    }
}
