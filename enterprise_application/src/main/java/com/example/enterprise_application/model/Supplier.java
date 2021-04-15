package com.example.enterprise_application.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;

    @Column(name = "supplierName")
    private String supplierName;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductInformation product;

    public Supplier(String supplierName, ProductInformation product) {
        this.supplierName = supplierName;
        this.product = product;
    }
}
