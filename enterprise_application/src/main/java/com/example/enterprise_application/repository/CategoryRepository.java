package com.example.enterprise_application.repository;

import com.example.enterprise_application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
