package com.abhishek.ecommercebackendsystem.Controllers;

import com.abhishek.ecommercebackendsystem.Dtos.OrderRequestDto;
import com.abhishek.ecommercebackendsystem.Dtos.OrderResponseDto;
import com.abhishek.ecommercebackendsystem.Dtos.ProductResponseDto;
import com.abhishek.ecommercebackendsystem.Models.OrderConfirmation;
import com.abhishek.ecommercebackendsystem.Models.OrderStatus;
import com.abhishek.ecommercebackendsystem.Models.Orders;
import com.abhishek.ecommercebackendsystem.Services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private ModelMapper modelMapper;

    private OrderService orderService;
    private ProductController productController;
    public OrderController(OrderService orderService, ProductController productController) {
        this.orderService = orderService;
        this.productController = productController;
    }

    @PostMapping("/")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        Orders savedOrder =  orderService.createOrder(orderRequestDto);
        OrderResponseDto orderResponseDto = modelMapper.map(savedOrder, OrderResponseDto.class);

        List<Long> productIds = savedOrder.getProductIds();
        for (int j=0; j<productIds.size(); j++) {
            ProductResponseDto productResponseDto = productController.getProductById(productIds.get(j));

            orderResponseDto.getProductResponseDtoList().add(productResponseDto);
        }
        return orderResponseDto;
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrderById(@PathVariable Long id) {
        Orders order = orderService.getOrderById(id);
        OrderResponseDto orderResponseDto = modelMapper.map(order, OrderResponseDto.class);
        List<Long> productIds = order.getProductIds();
        for (int j=0; j<productIds.size(); j++) {
            ProductResponseDto productResponseDto = productController.getProductById(productIds.get(j));
            orderResponseDto.getProductResponseDtoList().add(productResponseDto);
        }
        return orderResponseDto;
    }

    @PutMapping("/{id}")
    public OrderResponseDto updateOrder(@PathVariable Long id, @RequestBody OrderRequestDto orderRequestDto) {
        Orders order = orderService.updateOrder(id, orderRequestDto);
        OrderResponseDto orderResponseDto = modelMapper.map(order, OrderResponseDto.class);
        List<Long> productIds = order.getProductIds();
        for (int j=0; j<productIds.size(); j++) {
            ProductResponseDto productResponseDto = productController.getProductById(productIds.get(j));
            orderResponseDto.getProductResponseDtoList().add(productResponseDto);
        }
        return orderResponseDto;
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }

    @GetMapping("/customer/{id}")
    public List<OrderResponseDto> getOrderHistoryByCustomerId(@PathVariable Long id) {
        List<Orders> orders = orderService.getOrderHistoryByCustomerId(id);
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        for (int j=0; j<orders.size(); j++) {
            OrderResponseDto orderResponseDto = modelMapper.map(orders.get(j), OrderResponseDto.class);
            List<Long> productIds = orders.get(j).getProductIds();
            for (int k=0; k<productIds.size(); k++) {
                ProductResponseDto productResponseDto = productController.getProductById(productIds.get(k));
                orderResponseDto.getProductResponseDtoList().add(productResponseDto);
            }
            orderResponseDtos.add(orderResponseDto);
        }
        return orderResponseDtos;
    }

    @GetMapping("/status/{id}")
    public OrderStatus getOrderStatusById(@PathVariable Long id) {
        return orderService.getOrderStatusById(id);
    }

    @GetMapping("/orderConfirmation/{id}")
    public OrderConfirmation getOrderConfirmationById(@PathVariable Long id) {
        return orderService.getOrderConfirmationById(id);
    }
}
