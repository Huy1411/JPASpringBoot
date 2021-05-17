package com.example.enterprise_application.jpa;



import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regionId;

    @Column(name = "regionName")
    //@NotEmpty(message = "Region name must not be empty")
    @Size(min = 5,max = 255)
    private String regionName;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Country> country = new ArrayList<>();

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
        for (Country b: country){
            b.setRegion(this);
        }
    }
}
