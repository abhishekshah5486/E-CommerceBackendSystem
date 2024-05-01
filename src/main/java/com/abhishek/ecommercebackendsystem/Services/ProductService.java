package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
