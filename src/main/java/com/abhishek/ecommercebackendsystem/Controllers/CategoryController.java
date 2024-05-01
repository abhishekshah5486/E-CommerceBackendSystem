package com.abhishek.ecommercebackendsystem.Controllers;


import com.abhishek.ecommercebackendsystem.Models.Category;
import com.abhishek.ecommercebackendsystem.Models.Product;
import com.abhishek.ecommercebackendsystem.Services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Create a new product in the database
    @PostMapping("/")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    // Update an existing product in the database
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category){
        return categoryService.updateCategory(id, category);
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
