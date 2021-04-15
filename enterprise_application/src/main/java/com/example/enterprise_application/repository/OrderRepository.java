package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
