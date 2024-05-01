package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Models.Category;
import com.abhishek.ecommercebackendsystem.Models.Product;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}
