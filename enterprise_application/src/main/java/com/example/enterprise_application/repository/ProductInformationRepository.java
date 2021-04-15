package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.ProductInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInformationRepository extends JpaRepository<ProductInformation, Integer> {
}
