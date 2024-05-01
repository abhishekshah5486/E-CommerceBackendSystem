package com.abhishek.ecommercebackendsystem.Repositories;

import com.abhishek.ecommercebackendsystem.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
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

    @Query("SELECT p FROM Product p WHERE p.price < :price")
    List<Product> findByPriceLessThan(double price);

    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findByPriceGreaterThan(double price);

    @Query("SELECT p FROM Product p WHERE p.price = :price")
    List<Product> findByPriceEquals(double price);

    @Query("SELECT p FROM Product p WHERE p.price >= :minPrice AND p.price <= :maxPrice")
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
