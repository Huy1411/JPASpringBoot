package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
