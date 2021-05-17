package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Integer> {
}
