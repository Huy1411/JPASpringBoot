package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
