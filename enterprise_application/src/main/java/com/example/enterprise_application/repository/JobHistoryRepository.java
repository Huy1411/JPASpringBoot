package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.JobHistory;
import com.example.enterprise_application.model.JobHistoryID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryID> {
}
