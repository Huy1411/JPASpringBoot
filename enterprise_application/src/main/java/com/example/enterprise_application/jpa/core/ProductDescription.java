package com.example.enterprise_application.jpa.core;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ProductDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "translatedName")
    private String translatedName;

    @Column(name = "translatedDesc")
    private String translatedDesc;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTranslatedName() {
        return translatedName;
    }

    public void setTranslatedName(String translatedName) {
        this.translatedName = translatedName;
    }

    public String getTranslatedDesc() {
        return translatedDesc;
    }

    public void setTranslatedDesc(String translatedDesc) {
        this.translatedDesc = translatedDesc;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
