package com.example.enterprise_application.jpa.core;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fisrtName")
    private String fisrtName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "nlsLanguage")
    private String nlsLanguage;

    @Column(name = "nlsTorritory")
    private String nlsTorritory;

    @Column(name = "creditLimit")
    private String creditLimit;

    @Column(name = "email")
    private String email;

    @Column(name = "geoLocation")
    private String geoLocation;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "maritalStatus")
    private int maritalStatus;

    @Column(name = "gender")
    private String gender;

    @Column(name = "incomeLevel")
    private String incomeLevel;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> order = new HashSet<>();


    public Customer(String fisrtName, String lastName, String address, String phone, String nlsLanguage, String nlsTorritory, String creditLimit, String email, String geoLocation, Date dateOfBirth, int maritalStatus, String gender, String incomeLevel) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.nlsLanguage = nlsLanguage;
        this.nlsTorritory = nlsTorritory;
        this.creditLimit = creditLimit;
        this.email = email;
        this.geoLocation = geoLocation;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.incomeLevel = incomeLevel;
    }
}
