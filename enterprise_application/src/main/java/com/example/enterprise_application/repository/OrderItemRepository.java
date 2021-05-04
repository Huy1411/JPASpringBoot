package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.core.OrderItem;
import com.example.enterprise_application.jpa.core.OrderItemID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemID> {
}
