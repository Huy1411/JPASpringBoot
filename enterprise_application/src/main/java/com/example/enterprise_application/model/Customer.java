package com.example.enterprise_application.model;

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
    private int customerId;

    @Column(name = "custFisrtName")
    private String custFisrtName;

    @Column(name = "custLastName")
    private String custLastName;

    @Column(name = "custAddress")
    private String custAddress;

    @Column(name = "phone")
    private String phone;

    @Column(name = "nlsLanguage")
    private String nlsLanguage;

    @Column(name = "nlsTorritory")
    private String nlsTorritory;

    @Column(name = "creditLimit")
    private String creditLimit;

    @Column(name = "custEmail")
    private String custEmail;

    @Column(name = "custGeoLocation")
    private String custGeoLocation;

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

    public Customer(String custFisrtName, String custLastName, String custAddress, String phone, String nlsLanguage, String nlsTorritory, String creditLimit, String custEmail, String custGeoLocation, Date dateOfBirth, int maritalStatus, String gender, String incomeLevel) {
        this.custFisrtName = custFisrtName;
        this.custLastName = custLastName;
        this.custAddress = custAddress;
        this.phone = phone;
        this.nlsLanguage = nlsLanguage;
        this.nlsTorritory = nlsTorritory;
        this.creditLimit = creditLimit;
        this.custEmail = custEmail;
        this.custGeoLocation = custGeoLocation;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.incomeLevel = incomeLevel;
    }
}
