package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Integer> {
}
