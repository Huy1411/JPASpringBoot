package com.example.enterprise_application.jpa.core;

import com.example.enterprise_application.jpa.Location;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wareHouseId;

    @Column(name = "spec")
    private String spec;

    @Column(name = "name")
    //@NotEmpty(message = "WareHouse name must not be empty")
    @Size(min = 5,max = 255)
    private String wareHouseName;

    @Column(name = "geoLocation")
    private String geoLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationId", referencedColumnName = "locationId")
    private Location location;

    @OneToMany(mappedBy = "wareHouse", cascade = CascadeType.ALL)
    private Set<Inventory> inventory = new HashSet<>();

    public int getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(int wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getWareHouseName() {
        return wareHouseName;
    }

    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(Set<Inventory> inventory) {
        this.inventory = inventory;
        for (Inventory b: inventory){
            b.setWareHouse(this);
        }
    }
}
