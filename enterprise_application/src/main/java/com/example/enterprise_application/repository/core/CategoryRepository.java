package com.example.enterprise_application.repository.core;

import com.example.enterprise_application.jpa.core.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByStatus(int status);

    @Query("SELECT c FROM Category c WHERE category_name = ?1")
    Category findByCategoryName(String category_name);

    @Query("SELECT c FROM Category c WHERE status = 1 OR status = 2")
    List<Category> findActiveCategoryStatus();

    @Query("SELECT c FROM Category c WHERE status = 1 OR status = 2")
    Page<Category> findPaginateCategoryStatus(Pageable pageable);
}
