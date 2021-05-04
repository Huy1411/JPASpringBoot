package com.example.enterprise_application.jpa.core;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "hireDate")
    private Date hireDate;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "commissionPct")
    private String commissionPct;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<JobHistory> jobHistory = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    public Employee(String firstName, String lastName, String email, String phone, Date hireDate, Double salary, String commissionPct, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.department = department;
    }
}
