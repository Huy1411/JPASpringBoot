package com.example.enterprise_application.service.Impl.core;

import com.example.enterprise_application.jpa.core.Category;
import com.example.enterprise_application.repository.core.CategoryRepository;
import com.example.enterprise_application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> listCategories() {
        try{
            List<Category> list = categoryRepository.findActiveCategoryStatus();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> listCategoriesByStatus(int status) {
        try{
            List<Category> list = categoryRepository.findAllByStatus(status);
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category getCategoryById(int category_id) {
        try{
            Category category = categoryRepository.findById(category_id).get();
            return category;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveCategory(Category category) {
        try{
            categoryRepository.save(category);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCategory(Category category) {
        try{
            categoryRepository.save(category);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCategory(int category_id) {
        try{
            Category category = categoryRepository.findById(category_id).get();
            category.setStatus(3);
            categoryRepository.save(category);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkCategoryName(String category_name) {
        Category category = categoryRepository.findByCategoryName(category_name);
        if (category==null)
        {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Page<Category> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize, Sort.by("status"));
        return this.categoryRepository.findPaginateCategoryStatus(pageable);
    }
}
