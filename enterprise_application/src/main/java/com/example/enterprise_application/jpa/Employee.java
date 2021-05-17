package com.example.enterprise_application.jpa;



import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "\"employee\"")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "empName")
    @Size(min = 5,max = 255)
    private String empName;

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
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private Department department;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(String commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Set<JobHistory> getJobHistory() {
        return jobHistory;
    }

    public void setJobHistory(Set<JobHistory> jobHistory) {
        this.jobHistory = jobHistory;
        for (JobHistory b: jobHistory){
            b.setEmployee(this);
        }
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

