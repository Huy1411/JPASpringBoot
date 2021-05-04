package com.example.enterprise_application.jpa.core;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductInformation product;

    public Category(String name, ProductInformation product) {
        this.name = name;
        this.product = product;
    }
}
