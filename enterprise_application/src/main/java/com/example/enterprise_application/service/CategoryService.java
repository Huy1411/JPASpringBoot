package com.example.enterprise_application.service;

import com.example.enterprise_application.jpa.core.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    List<Category> listCategoriesByStatus(int status);
    Category getCategoryById(int cate_id);
    boolean saveCategory(Category category);
    boolean updateCategory(Category category);
    boolean deleteCategory(int category_id);
    boolean checkCategoryName(String category_name);
    Page<Category> findPaginated(int pageNo, int pageSize);
}
