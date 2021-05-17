package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    List<Customer> findByEmail(String email);
    @Query("SELECT c FROM Customer c")
    Page<Customer> findPaginateCustomers(Pageable pageable);
}
