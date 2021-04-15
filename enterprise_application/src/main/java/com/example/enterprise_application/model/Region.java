package com.example.enterprise_application.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regionId;

    @Column(name = "regionName")
    private String regionName;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private Set<Country> country = new HashSet<>();

    public Region(String regionName) {
        this.regionName = regionName;
    }
}
