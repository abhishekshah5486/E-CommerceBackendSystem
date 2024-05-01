package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Dtos.OrderRequestDto;
import com.abhishek.ecommercebackendsystem.Models.Orders;

public interface OrderService {
    Orders createOrder(OrderRequestDto orderRequestDto);
    Orders getOrderById(Long id);
}
