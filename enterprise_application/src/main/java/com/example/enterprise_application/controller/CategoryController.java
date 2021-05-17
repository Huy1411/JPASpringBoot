package com.example.enterprise_application.controller;

import com.example.enterprise_application.jpa.core.Category;
import com.example.enterprise_application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @InitBinder
    public void InitBinder(WebDataBinder data) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping(path = "")
    public String getCategories(Model model) {
        Category category = new Category();
        return findPaginated(1, model, category);
    }

    @RequestMapping(path = "saveCategory", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("categoryNew") @Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return findPaginated(1, model, category);
        }
        boolean checkCateName = categoryService.checkCategoryName(category.getCategoryName());
        if (checkCateName==false)
        {
            return "redirect:/admin/category?errorcategoryname=CategoryName is existed";
        }
        boolean bl = categoryService.saveCategory(category);
        if (bl) {
            return "redirect:/admin/category?success=Add New category success";
        }
        return "redirect:/admin/category?error=Add New category failed";
    }

    @RequestMapping(path = "editCategory")
    public String editCategory(@RequestParam("id") Integer id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("categoryEdit", category);
        return "admin/category/editCategory";

    }

    @RequestMapping(path = "updateCategory", method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("categoryEdit") Category category) {

        boolean checkName = checkCategoryNameEdit(category.getCategoryName(),category.getCategoryId());
        if (checkName==false)
        {
            return "redirect:/admin/category/editCategory?id="+category.getCategoryId()+"&&errorcatename=CategoryName is existed";
        }
        boolean bl = categoryService.updateCategory(category);
        if (bl) {
            return "redirect:/admin/category?success=Update category success";
        }
        return "redirect:/admin/category?error=Update category failed";
    }

    @RequestMapping(path = "deleteCategory")
    public String deleteCategory(@RequestParam("id") Integer id) {
        boolean bl = categoryService.deleteCategory(id);
        if (bl) {
            return "redirect:/admin/category?success=Delete category success";
        }
        return "redirect:/admin/category?error=Delete category failed";
    }

    @RequestMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model, Category category) {
        int pageSize = 10;
        Page<Category> page = categoryService.findPaginated(pageNo, pageSize);
        List<Category> listCategory = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("list", listCategory);
        model.addAttribute("categoryNew", category);
        return "admin/category/categoryList";
    }

    public boolean checkCategoryNameEdit(String category_name,int category_id)
    {
        Category categoryEdit = categoryService.getCategoryById(category_id);
        boolean checkCategoryName = categoryService.checkCategoryName(category_name);
        if (checkCategoryName==false)
        {
            if (category_name.equals(categoryEdit.getCategoryName()))
            {
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
