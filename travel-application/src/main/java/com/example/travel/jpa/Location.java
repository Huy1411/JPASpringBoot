package com.example.travel.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"image","author","publisher"})
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    @NotNull
    private String locationName;

    private String locationAddress;

    private String locationInfo;

    @Min(value = 1,message = "Please chose a status")
    private int status;

    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("locations")
    private Set<Image> images = new HashSet<>();

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("locations")
    private Set<Comment> comments = new HashSet<>();

}
