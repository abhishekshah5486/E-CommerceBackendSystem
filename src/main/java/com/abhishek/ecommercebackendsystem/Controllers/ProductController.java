package com.abhishek.ecommercebackendsystem.Controllers;

import com.abhishek.ecommercebackendsystem.Models.Product;
import com.abhishek.ecommercebackendsystem.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// This controller is capable to host http APIs Rest Controller
@RequestMapping("/products")
// localhost:8080/products --> product controller
// Request mapping creates a mapping of this end point with this controller in the
// dispatcher servlet
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Get a product by id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    // Get the list of all the products
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Create a new product in the database
    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    // Update an existing product in the database
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Find all products having price less than the given price
    @GetMapping("/?filter=lessThan?price={price}")
    public List<Product> findByPriceLessThan(@PathVariable Double price) {
        return productService.findByPriceLessThan(price);
    }

    // Find all products having price greater than the given price
    @GetMapping("/?filter=greaterThan?price={price}")
    public List<Product> findByPriceGreaterThan(@PathVariable Double price) {
        return productService.findByPriceGreaterThan(price);
    }

    // Find all products having price equal to the given price
    @GetMapping("/?filter=equalsTo?price={price}")
    public List<Product> findByPriceEquals(@PathVariable Double price) {
        return productService.findByPriceEquals(price);
    }

    // Find all products having price between minPrice and maxPrice
    @GetMapping("/?filter=Between?minPrice={minPrice}&maxPrice={maxPrice}")
    public List<Product> findByPriceEquals(@PathVariable Double minPrice, @PathVariable Double maxPrice) {
        return productService.findByPriceBetween(minPrice, maxPrice);
    }

    // Filter all products by category
    @GetMapping("/?filter=category?title={title}")
    public List<Product> findByCategory(@PathVariable String title) {
        return productService.findProductsByCategory(title);
    }
}
