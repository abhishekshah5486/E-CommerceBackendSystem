package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Dtos.CustomerRequestDto;
import com.abhishek.ecommercebackendsystem.Dtos.CustomerResponseDto;
import com.abhishek.ecommercebackendsystem.Dtos.OrderResponseDto;
import com.abhishek.ecommercebackendsystem.Exceptions.InvalidCustomerIdException;
import com.abhishek.ecommercebackendsystem.Exceptions.NoCustomerFoundException;
import com.abhishek.ecommercebackendsystem.Models.Customer;
import com.abhishek.ecommercebackendsystem.Models.Orders;
import com.abhishek.ecommercebackendsystem.Repositories.CustomerRepository;
import com.abhishek.ecommercebackendsystem.Repositories.OrderRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private OrderService orderService;
    public CustomerServiceImpl(CustomerRepository customerRepository, OrderService orderService) {
        this.customerRepository = customerRepository;
        this.orderService = orderService;
    }

    @Override
    public Customer createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();
        customer.setName(customerRequestDto.getName());
        customer.setEmail(customerRequestDto.getEmail());

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw new InvalidCustomerIdException("Invalid Customer Id Found", id);
        }
        return optionalCustomer.get();
    }

    @Override
    public Customer updateCustomer(CustomerRequestDto customerRequestDto, Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw new InvalidCustomerIdException("Invalid Customer Id Found", id);
        }
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(customerRequestDto.getName());
        customer.setEmail(customerRequestDto.getEmail());

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw new NoCustomerFoundException("No Customer with this id exists.");
        }
        customerRepository.deleteById(id);
    }

    @Override
    public List<Orders> getOrderHistory(Long id) {
        Customer customer = getCustomerById(id);
        List<Long> orderIds = customer.getOrderIds();
        List<Orders> orders = new ArrayList<>();

        for (int i = 0; i < orderIds.size(); i++) {
            Orders order = new Orders();
            order = orderService.getOrderById(orderIds.get(i));
            orders.add(order);
        }
        return orders;
    }
}
