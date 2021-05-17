package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    @Query("SELECT c FROM Department c")
    Page<Department> findPaginateDepartments(Pageable pageable);
}


