package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.core.ProductInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductInformationRepository extends JpaRepository<ProductInformation, Integer> {
}
