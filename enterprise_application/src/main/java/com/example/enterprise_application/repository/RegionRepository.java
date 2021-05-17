package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}
