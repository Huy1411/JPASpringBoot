package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
