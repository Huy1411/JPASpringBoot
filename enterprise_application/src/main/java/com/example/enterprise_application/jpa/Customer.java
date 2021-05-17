package com.example.enterprise_application.jpa;

import com.example.enterprise_application.jpa.core.Order;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "customertName")
    //@NotEmpty(message = "First name must not be empty")
    @Size(min = 5,max = 255)
    private String customerName;


    @Column(name = "email")
    @Size(min = 5,max = 255)
    private String email;

    @Column(name = "address")
    @Size(min = 5,max = 255)
    private String address;

    @Column(name = "phone")
    @Size(min = 5,max = 255)
    private String phone;

    @Column(name = "nlsLanguage")
    private String nlsLanguage;

    @Column(name = "nlsTorritory")
    private String nlsTorritory;

    @Column(name = "creditLimit")
    private String creditLimit;

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

//    private Boolean isActive;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> order = new HashSet<>();

//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//    private VerificationToken verificationToken;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNlsLanguage() {
        return nlsLanguage;
    }

    public void setNlsLanguage(String nlsLanguage) {
        this.nlsLanguage = nlsLanguage;
    }

    public String getNlsTorritory() {
        return nlsTorritory;
    }

    public void setNlsTorritory(String nlsTorritory) {
        this.nlsTorritory = nlsTorritory;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(String incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
        for (Order b: order){
            b.setCustomer(this);
        }
    }
}
