package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Dtos.CustomerRequestDto;
import com.abhishek.ecommercebackendsystem.Models.Customer;

public interface CustomerService {
    Customer createCustomer(CustomerRequestDto customerRequestDto);
    Customer getCustomerById(Long id);
    Customer updateCustomer(CustomerRequestDto customerRequestDto, Long id);
    void deleteCustomer(Long id);
}
