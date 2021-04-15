package com.example.enterprise_application.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(name = "departmentName")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<JobHistory> jobHistory = new HashSet<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Employee> employee = new HashSet<>();

    public Department(String departmentName, Location location) {
        this.departmentName = departmentName;
        this.location = location;
    }
}
