package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Models.Customer;
import com.abhishek.ecommercebackendsystem.Repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import

@Service
public class CustomerServiceImpl implements CustomerService{

    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(String name, String email, String username, String password, String address, String phone) {
        Customer customer = new Customer(name, email, username, password, address, phone);
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateName(String name, Long id) {
        if(customerRepository.findById(id).isEmpty()){
            throw new CustomerNotFoundException();
        }
        Customer customer = customerRepository.findById(id);
        customer.setName(name);
        customerRepository.save(customer);
    }
}
