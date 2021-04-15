package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDescriptionRepository extends JpaRepository<ProductDescription, Integer> {
}
