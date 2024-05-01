package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> findByPriceLessThan(double price);
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
    List<Product> findByPriceEquals(double price);
    List<Product> findProductsByCategory(String category);
    List<Product> findProductByPopularity(double rating);
    List<Product> sortProductsByPopularityAsc();
    List<Product> sortProductsByPopularityDesc();
    List<Product> sortProductsByPriceAsc();
    List<Product> sortProductsByPriceDesc();
}
