package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
