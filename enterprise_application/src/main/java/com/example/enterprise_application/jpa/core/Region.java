package com.example.enterprise_application.jpa.core;


import com.example.enterprise_application.jpa.core.Country;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Country> country = new ArrayList<>();

    public Region(String name, List<Country> country) {
        this.name = name;
        this.country = country;
    }
}
