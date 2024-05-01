package com.abhishek.ecommercebackendsystem.Repositories;

import com.abhishek.ecommercebackendsystem.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    @Override
    void deleteById(Long aLong);
}
