package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.core.Inventory;
import com.example.enterprise_application.jpa.core.InventoryID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InventoryRepository extends JpaRepository<Inventory, InventoryID> {
}
