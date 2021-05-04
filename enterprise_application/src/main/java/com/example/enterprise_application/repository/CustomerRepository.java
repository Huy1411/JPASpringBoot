package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.core.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
