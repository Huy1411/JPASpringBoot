package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, Integer>{
    @Query("SELECT c FROM Country c ")
    Page<Country> findPaginateCountries(Pageable pageable);

}
