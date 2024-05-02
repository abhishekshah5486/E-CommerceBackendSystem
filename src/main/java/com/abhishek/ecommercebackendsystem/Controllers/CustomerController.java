package com.abhishek.ecommercebackendsystem.Controllers;

import com.abhishek.ecommercebackendsystem.Dtos.CustomerRequestDto;
import com.abhishek.ecommercebackendsystem.Dtos.CustomerResponseDto;
import com.abhishek.ecommercebackendsystem.Dtos.OrderResponseDto;
import com.abhishek.ecommercebackendsystem.Dtos.ProductResponseDto;
import com.abhishek.ecommercebackendsystem.Models.Customer;
import com.abhishek.ecommercebackendsystem.Models.Orders;
import com.abhishek.ecommercebackendsystem.Repositories.CustomerRepository;
import com.abhishek.ecommercebackendsystem.Services.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;
    private OrderController orderController;

    @Autowired
    private ModelMapper modelMapper;
    public CustomerController(CustomerService customerService, OrderController orderController) {
        this.customerService = customerService;
        this.orderController = orderController;
    }

    @GetMapping("/{id}")
    public CustomerResponseDto getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return modelMapper.map(customer, CustomerResponseDto.class);
    }
    @PostMapping("/")
    public CustomerResponseDto createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        Customer savedCustomer = customerService.createCustomer(customerRequestDto);
        return modelMapper.map(savedCustomer, CustomerResponseDto.class);
    }

    @PutMapping("/{id}")
    public CustomerResponseDto updateCustomer(@RequestBody CustomerRequestDto customerRequestDto, @PathVariable Long id) {
        Customer customer = customerService.updateCustomer(customerRequestDto, id);
        return modelMapper.map(customer, CustomerResponseDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/orders/{id}")
    public List<OrderResponseDto> getOrderHistoryByCustomerId(@PathVariable Long id) {
        return orderController.getOrderHistoryByCustomerId(id);
    }
}
