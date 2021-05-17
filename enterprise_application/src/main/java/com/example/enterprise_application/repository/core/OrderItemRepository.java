package com.example.enterprise_application.repository.core;

import com.example.enterprise_application.jpa.core.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
