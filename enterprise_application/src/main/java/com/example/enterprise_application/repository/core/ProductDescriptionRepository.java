package com.example.enterprise_application.repository.core;

import com.example.enterprise_application.jpa.core.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDescriptionRepository extends JpaRepository<ProductDescription, Integer> {
}
