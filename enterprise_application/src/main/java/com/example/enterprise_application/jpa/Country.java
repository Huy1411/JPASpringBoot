package com.example.enterprise_application.jpa;



import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;

    @Column(name = "countryName")
    //@NotEmpty(message = "Country name must not be empty")
    @Size(min = 5,max = 255)
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "regionId", referencedColumnName = "regionId")
    private Region region;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
