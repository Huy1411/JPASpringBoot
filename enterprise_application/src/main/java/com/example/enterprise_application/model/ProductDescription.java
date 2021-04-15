package com.example.enterprise_application.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ProductDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int languageId;

    @Column(name = "translatedName")
    private String translatedName;

    @Column(name = "translatedDesc")
    private String translatedDesc;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductInformation product;

    public ProductDescription(String translatedName, String translatedDesc, ProductInformation product) {
        this.translatedName = translatedName;
        this.translatedDesc = translatedDesc;
        this.product = product;
    }
}
