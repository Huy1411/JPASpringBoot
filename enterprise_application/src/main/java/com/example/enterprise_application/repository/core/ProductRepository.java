package com.example.enterprise_application.repository.core;

import com.example.enterprise_application.jpa.core.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
