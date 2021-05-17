package com.example.enterprise_application.repository.core;

import com.example.enterprise_application.jpa.core.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
