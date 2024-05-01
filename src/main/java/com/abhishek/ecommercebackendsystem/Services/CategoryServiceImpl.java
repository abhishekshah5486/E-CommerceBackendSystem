package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Exceptions.InvalidCategoryIdException;
import com.abhishek.ecommercebackendsystem.Exceptions.NoCategoriesFoundException;
import com.abhishek.ecommercebackendsystem.Models.Category;
import com.abhishek.ecommercebackendsystem.Repositories.CategoryRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new InvalidCategoryIdException("Category Id does not exist", id);
        }
        return optionalCategory.get();
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new NoCategoriesFoundException("No categories found");
        }
        return categories;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new InvalidCategoryIdException("Category Id does not exist", id);
        }
        categoryRepository.deleteById(id);
    }
}
