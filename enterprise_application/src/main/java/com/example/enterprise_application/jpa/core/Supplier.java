//package com.example.enterprise_application.jpa.core;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.Size;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Data
//@Entity
//public class Supplier {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int supplierId;
//
//    @Column(name = "supplierName")
//    @Size(min = 5,max = 60)
//    private String supplierName;
//
//    @Column(name = "desc")
//    @Size(min = 5,max = 255)
//    private String supplierDesc;
//
//    @Column(name = "address")
//    @Size(min = 5,max = 255)
//    private String address;
//
//    @Column(name = "email")
//    @Size(min = 5,max = 255)
//    private String email;
//
//    @Column(name = "phone")
//    @Size(min = 5,max = 255)
//    private String phone;
//
//    @Min(value = 1,message = "Please chose a status")
//    private int status;
//
//    @OneToMany(mappedBy = "supplier")
//    private Set<Product> products = new HashSet<>();
//
//}
