package com.abhishek.ecommercebackendsystem.Controllers;

import com.abhishek.ecommercebackendsystem.Dtos.OrderRequestDto;
import com.abhishek.ecommercebackendsystem.Dtos.OrderResponseDto;
import com.abhishek.ecommercebackendsystem.Models.Order;
import com.abhishek.ecommercebackendsystem.Repositories.OrderRepository;
import com.abhishek.ecommercebackendsystem.Services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private ModelMapper modelMapper;

    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        Order savedOrder =  orderService.createOrder(orderRequestDto);
        OrderResponseDto orderResponseDto = modelMapper.map(savedOrder, OrderResponseDto.class);
        return orderResponseDto;
    }
}
