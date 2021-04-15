package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.Inventory;
import com.example.enterprise_application.model.InventoryID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, InventoryID> {
}
