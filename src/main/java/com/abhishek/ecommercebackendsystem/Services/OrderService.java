package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Dtos.OrderRequestDto;
import com.abhishek.ecommercebackendsystem.Models.OrderConfirmation;
import com.abhishek.ecommercebackendsystem.Models.OrderStatus;
import com.abhishek.ecommercebackendsystem.Models.Orders;

import java.util.List;

public interface OrderService {
    Orders createOrder(OrderRequestDto orderRequestDto);
    Orders getOrderById(Long id);
    void deleteOrderById(Long id);
    Orders updateOrder(Long id, OrderRequestDto orderRequestDto);
    List<Orders> getOrderHistoryByCustomerId(Long id);
    OrderStatus getOrderStatusById(Long id);
    OrderConfirmation getOrderConfirmationById(Long id);
}
