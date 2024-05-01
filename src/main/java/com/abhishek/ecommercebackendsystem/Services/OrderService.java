package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Dtos.OrderRequestDto;
import com.abhishek.ecommercebackendsystem.Models.Order;
import org.springframework.stereotype.Service;

public interface OrderService {
    Order createOrder(OrderRequestDto orderRequestDto);
}
