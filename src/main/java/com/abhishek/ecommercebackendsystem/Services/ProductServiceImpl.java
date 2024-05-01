package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Exceptions.InvalidProductIdException;
import com.abhishek.ecommercebackendsystem.Exceptions.NoProductsFoundException;
import com.abhishek.ecommercebackendsystem.Models.Category;
import com.abhishek.ecommercebackendsystem.Models.Inventory;
import com.abhishek.ecommercebackendsystem.Models.Product;
import com.abhishek.ecommercebackendsystem.Repositories.CategoryRepository;
import com.abhishek.ecommercebackendsystem.Repositories.InventoryRepository;
import com.abhishek.ecommercebackendsystem.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private InventoryRepository inventoryRepository;
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, InventoryRepository inventoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.inventoryRepository = inventoryRepository;
    }
    @Override
    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new InvalidProductIdException("Invalid Product ID Found", id);
        }
        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
       List<Product> allProducts = productRepository.findAll();
       if (allProducts.isEmpty()) {
           throw new NoProductsFoundException("No products found");
       }
       return allProducts;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if (category.getId() == null){
            // Save the category first, then save the product with that id
            product.setCategory(categoryRepository.save(category));
        }
        Inventory inventory = product.getInventory();
        if (inventory.getId() == null){
            product.setInventory(inventoryRepository.save(inventory));
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new InvalidProductIdException("Invalid Product ID Found", id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByPriceLessThan(double price) {
        List<Product> allProducts = productRepository.findByPriceLessThan(price);
        if (allProducts.isEmpty()) {
            throw new NoProductsFoundException("No products found");
        }
        return allProducts;
    }

    @Override
    public List<Product> findByPriceGreaterThan(double price) {
        List<Product> allProducts = productRepository.findByPriceGreaterThan(price);
        if (allProducts.isEmpty()) {
            throw new NoProductsFoundException("No products found");
        }
        return allProducts;
    }

    @Override
    public List<Product> findByPriceBetween(double minPrice, double maxPrice) {
        List<Product> allProducts = productRepository.findByPriceBetween(minPrice, maxPrice);
        if (allProducts.isEmpty()) {
            throw new NoProductsFoundException("No products found");
        }
        return allProducts;
    }

    @Override
    public List<Product> findByPriceEquals(double price) {
        List<Product> allProducts = productRepository.findByPriceEquals(price);
        if (allProducts.isEmpty()) {
            throw new NoProductsFoundException("No products found");
        }
        return allProducts;
    }

    @Override
    public List<Product> findProductsByCategory(String title) {
        List<Product> allProducts = productRepository.findProductsByCategory(title);
        if (allProducts.isEmpty()) {
            throw new NoProductsFoundException("No products found");
        }
        return allProducts;
    }
}
