package com.example.enterprise_application.jpa.core;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region region;

    public Country(String name, Region region) {
        this.name = name;
        this.region = region;
    }

}
