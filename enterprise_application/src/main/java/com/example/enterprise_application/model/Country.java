package com.example.enterprise_application.model;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;

    @Column(name = "countryName")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region region;

    public Country(String countryName, Region region) {
        this.countryName = countryName;
        this.region = region;
    }
}
