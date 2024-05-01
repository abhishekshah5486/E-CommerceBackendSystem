package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Models.Customer;
import com.abhishek.ecommercebackendsystem.Models.Order;
import com.abhishek.ecommercebackendsystem.Models.OrderStatus;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    void createCustomer(String name, String email, String username, String password, String address, String phone);
    void deleteCustomer(Long id);
    void updateName(String name, Long id);
    void updateEmail(String email, Long id);
    void updateUsername(String username, Long id);
    void updatePassword(String password, Long id);
    void updateAddress(String address, Long id);
    void updatePhone(String phone, Long id);

    Customer findById(Long id);
    List<Order> getAllOrders(Long id);
//    void deleteOrder(Long id);
    OrderStatus getOrderStatus(Long id);
}
