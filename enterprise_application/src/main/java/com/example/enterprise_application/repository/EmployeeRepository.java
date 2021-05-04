package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.core.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
