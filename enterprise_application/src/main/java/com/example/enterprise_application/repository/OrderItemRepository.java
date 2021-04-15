package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.OrderItem;
import com.example.enterprise_application.model.OrderItemID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemID> {
}
