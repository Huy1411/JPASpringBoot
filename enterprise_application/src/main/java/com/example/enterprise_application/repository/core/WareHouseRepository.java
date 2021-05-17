package com.example.enterprise_application.repository.core;

import com.example.enterprise_application.jpa.core.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WareHouseRepository extends JpaRepository<WareHouse, Integer> {
}
