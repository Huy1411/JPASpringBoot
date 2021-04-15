package com.example.enterprise_application.model;


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
    private int productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productDesc")
    private String productDesc;

    @Column(name = "weightClass")
    private String weightClass;

    @Column(name = "productStatus")
    private int productStatus;

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

    public ProductInformation(String productName, String productDesc, String weightClass, int productStatus, Double listPrice, Double minPrice, String catalogUrl) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.weightClass = weightClass;
        this.productStatus = productStatus;
        this.listPrice = listPrice;
        this.minPrice = minPrice;
        this.catalogUrl = catalogUrl;
    }
}
