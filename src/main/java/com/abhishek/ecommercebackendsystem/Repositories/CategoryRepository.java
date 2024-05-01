package com.abhishek.ecommercebackendsystem.Repositories;

import com.abhishek.ecommercebackendsystem.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Category save(Category category);
}
