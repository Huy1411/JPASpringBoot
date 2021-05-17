package com.example.enterprise_application.jpa;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(name = "departmentName")
    //@NotEmpty(message = "Department name must not be empty")
    @Size(min = 5,max = 255)
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "locationId")
    private Location location;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<JobHistory> jobHistory = new HashSet<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Employee> employee = new HashSet<>();

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<JobHistory> getJobHistory() {
        return jobHistory;
    }

    public void setJobHistory(Set<JobHistory> jobHistory) {
        this.jobHistory = jobHistory;
        for (JobHistory b: jobHistory){
            b.setDepartment(this);
        }
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
        for (Employee b: employee){
            b.setDepartment(this);
        }
    }
}
