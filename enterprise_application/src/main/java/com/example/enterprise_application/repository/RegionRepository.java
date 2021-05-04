package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.core.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
