package com.example.enterprise_application.jpa.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class JobHistoryDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobHistoryId;

    private Date startDate;

    private Date endDate;

    private int employeeId;

    private int departmentId;

    private int jobId;

    public int getJobHistoryId() {
        return jobHistoryId;
    }

    public void setJobHistoryId(int jobHistoryId) {
        this.jobHistoryId = jobHistoryId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
