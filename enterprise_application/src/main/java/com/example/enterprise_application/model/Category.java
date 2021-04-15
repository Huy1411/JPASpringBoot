package com.example.enterprise_application.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "categoryName")
    private String cateogoryName;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductInformation product;



}
