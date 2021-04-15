package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
