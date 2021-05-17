package com.example.enterprise_application.repository.core;

import com.example.enterprise_application.jpa.core.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
