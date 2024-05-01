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
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
