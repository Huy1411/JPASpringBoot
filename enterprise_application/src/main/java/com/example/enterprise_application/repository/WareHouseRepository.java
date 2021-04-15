package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WareHouseRepository extends JpaRepository<WareHouse, Integer> {
}
