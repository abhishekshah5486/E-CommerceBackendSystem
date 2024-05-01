package com.abhishek.ecommercebackendsystem.Repositories;

import com.abhishek.ecommercebackendsystem.Models.Category;
import com.abhishek.ecommercebackendsystem.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    @Override
    void deleteById(Long id);

    @Query("SELECT p FROM Product p WHERE p.price < :price")
    List<Product> findByPriceLessThan(@Param("price") double price);

    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findByPriceGreaterThan(double price);

    @Query("SELECT p FROM Product p WHERE p.price = :price")
    List<Product> findByPriceEquals(double price);

    @Query("SELECT p FROM Product p WHERE p.price >= :minPrice AND p.price <= :maxPrice")
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

//    @Query("SELECT p FROM Product p WHERE p.category.title = :title")
    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.title = :title")
    List<Product> findProductsByCategory(String title);

    @Query("SELECT p FROM Product p WHERE p.rating = :rating")
    List<Product> findProductByPopularity(double rating);

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> sortProductsByPriceAsc();

    @Query("SELECT p FROM Product p ORDER BY p.rating ASC")
    List<Product> sortProductsByPopularityAsc();

    @Query("SELECT p FROM Product p ORDER BY p.rating DESC")
    List<Product> sortProductsByPopularityDesc();

    @Query("SELECT p FROM Product p ORDER BY p.price DESC")
    List<Product> sortProductsByPriceDesc();

}
