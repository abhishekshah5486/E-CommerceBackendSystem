package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Dtos.CustomerRequestDto;
import com.abhishek.ecommercebackendsystem.Dtos.OrderResponseDto;
import com.abhishek.ecommercebackendsystem.Models.Customer;
import com.abhishek.ecommercebackendsystem.Models.Orders;
import jakarta.persistence.criteria.Order;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerRequestDto customerRequestDto);
    Customer getCustomerById(Long id);
    Customer updateCustomer(CustomerRequestDto customerRequestDto, Long id);
    void deleteCustomer(Long id);
    void updateCustomerOrderIds(Long id, List<Long> orderIds);
}
