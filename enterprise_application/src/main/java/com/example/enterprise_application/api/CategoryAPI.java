package com.example.enterprise_application.api;

import com.example.enterprise_application.jpa.core.Category;
import com.example.enterprise_application.repository.core.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryAPI {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(path = "")
    public List<Category> getCategory()
    {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @RequestMapping(path = "/status")
    public List<Category> getCateByStatus(@RequestParam("status")Integer status)
    {
        List<Category> categories = categoryRepository.findAllByStatus(status);
        return categories;
    }


    @RequestMapping(path = "",method = RequestMethod.POST)
    public Category saveCategory(@Valid @RequestBody Category category)
    {
        return this.categoryRepository.save(category);
    }
}
