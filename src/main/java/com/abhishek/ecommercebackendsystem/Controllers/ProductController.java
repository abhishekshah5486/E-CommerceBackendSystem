package com.abhishek.ecommercebackendsystem.Controllers;

import com.abhishek.ecommercebackendsystem.Dtos.ProductResponseDto;
import com.abhishek.ecommercebackendsystem.Models.Product;
import com.abhishek.ecommercebackendsystem.Services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// This controller is capable to host http APIs Rest Controller
@RequestMapping("/products")
// localhost:8080/products --> product controller
// Request mapping creates a mapping of this end point with this controller in the
// dispatcher servlet
public class ProductController {
    @Autowired
    private ModelMapper modelMapper;

    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Get a product by id
    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        ProductResponseDto productResponseDto = modelMapper.map(product, ProductResponseDto.class);
        return productResponseDto;
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
    @GetMapping("/price/lessthan/{price}")
    public List<Product> findByPriceLessThan(@PathVariable Double price) {
        return productService.findByPriceLessThan(price);
    }

    // Find all products having price greater than the given price
    @GetMapping("/price/greaterthan/{price}")
    public List<Product> findByPriceGreaterThan(@PathVariable Double price) {
        return productService.findByPriceGreaterThan(price);
    }

    // Find all products having price equal to the given price
    @GetMapping("/price/equals/{price}")
    public List<Product> findByPriceEquals(@PathVariable Double price) {
        return productService.findByPriceEquals(price);
    }

    // Find all products having price between minPrice and maxPrice
    @GetMapping("/priceRange/{minPrice}/{maxPrice}")
    public List<Product> findByPriceBetween(@PathVariable Double minPrice, @PathVariable Double maxPrice) {
        return productService.findByPriceBetween(minPrice, maxPrice);
    }

    // Filter all products by category
    @GetMapping("/category/{title}")
    public List<Product> findByCategory(@PathVariable String title) {
        return productService.findProductsByCategory(title);
    }

    // Filter all products by rating/popularity
    @GetMapping("/rating/{rating}")
    public List<Product> findByCategory(@PathVariable double rating) {
        return productService.findProductByPopularity(rating);
    }

    @GetMapping("/sort/price/asc")
    public List<Product> sortProductsByPriceAsc() {
        return productService.sortProductsByPriceAsc();
    }

    @GetMapping("/sort/price/desc")
    public List<Product> sortProductsByPriceDesc() {
        return productService.sortProductsByPriceDesc();
    }

    @GetMapping("/sort/popularity/asc")
    public List<Product> sortProductsByPopularityAsc() {
        return productService.sortProductsByPopularityAsc();
    }

    @GetMapping("/sort/popularity/desc")
    public List<Product> sortProductsByPopularityDesc() {
        return productService.sortProductsByPopularityDesc();
    }
}
