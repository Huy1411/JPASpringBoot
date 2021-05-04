package com.example.enterprise_application.jpa.core;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class ProductInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "\"desc\"")
    private String desc;

    @Column(name = "weightClass")
    private String weightClass;

    @Column(name = "status")
    private int status;

    @Column(name = "listPrice")
    private Double listPrice;

    @Column(name = "minPrice")
    private Double minPrice;

    @Column(name = "catalogUrl")
    private String catalogUrl;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Category> category = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Supplier> supplier = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItem = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Inventory> inventory = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductDescription> productDescription = new HashSet<>();

    public ProductInformation(String name, String desc, String weightClass, int status, Double listPrice, Double minPrice, String catalogUrl) {
        this.name = name;
        this.desc = desc;
        this.weightClass = weightClass;
        this.status = status;
        this.listPrice = listPrice;
        this.minPrice = minPrice;
        this.catalogUrl = catalogUrl;
    }
}
