package com.example.enterprise_application.jpa;



import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;

    @Column(name = "jobTitle")
    //@NotEmpty(message = "Job title must not be empty")
    @Size(min = 5,max = 255)
    private String jobTitle;

    @Column(name = "minSalary")
    private double minSalary;

    @Column(name = "maxSalary")
    private double maxSalary;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private Set<JobHistory> jobHistory = new HashSet<>();

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Set<JobHistory> getJobHistory() {
        return jobHistory;
    }

    public void setJobHistory(Set<JobHistory> jobHistory) {
        this.jobHistory = jobHistory;
        for (JobHistory b: jobHistory){
            b.setJob(this);
        }
    }
}
