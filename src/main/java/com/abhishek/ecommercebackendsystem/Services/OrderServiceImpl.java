package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Dtos.OrderRequestDto;
import com.abhishek.ecommercebackendsystem.Models.Order;
import com.abhishek.ecommercebackendsystem.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setCustomerId(orderRequestDto.getCustomerId());
        order.setProductIds(orderRequestDto.getProductIds());
        return orderRepository.save(order);
    }
}
