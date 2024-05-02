package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Controllers.CustomerController;
import com.abhishek.ecommercebackendsystem.Dtos.CustomerRequestDto;
import com.abhishek.ecommercebackendsystem.Dtos.OrderRequestDto;
import com.abhishek.ecommercebackendsystem.Exceptions.InvalidOrderIdException;
import com.abhishek.ecommercebackendsystem.Exceptions.NoCustomerFoundException;
import com.abhishek.ecommercebackendsystem.Exceptions.NoOrderHistoryFoundException;
import com.abhishek.ecommercebackendsystem.Exceptions.ProductOutOfStockException;
import com.abhishek.ecommercebackendsystem.Models.*;
import com.abhishek.ecommercebackendsystem.Repositories.CustomerRepository;
import com.abhishek.ecommercebackendsystem.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ProductService productService;
    private CustomerService customerService;
    public OrderServiceImpl(OrderRepository orderRepository, ProductService productService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.customerService = customerService;
    }

    @Override
    public Orders createOrder(OrderRequestDto orderRequestDto) {
        Long customerId = orderRequestDto.getCustomerId();
        Orders order = new Orders();
        order.setCustomerId(customerId);
        order.setProductIds(orderRequestDto.getProductIds());

        List<Long> productIds = orderRequestDto.getProductIds();
        // Check if all the products are in stock
        // Throw an exception if out of stock
        for (int j=0; j<productIds.size(); j++) {
            Product product = productService.getProductById(productIds.get(j));
            if (product.getProductAvailability() == ProductAvailability.OUT_OF_STOCK){
                throw new ProductOutOfStockException("Product is currently out of stock.",productIds.get(j));
            }
        }
        // Calculate the total amount for the products during checkout
        double totalAmount = 0;
        for (int j=0; j<productIds.size(); j++) {
            Product product = productService.getProductById(productIds.get(j));
            totalAmount = totalAmount + product.getPrice();
        }
        order.setTotalAmount(totalAmount);
        Orders savedOrder =  orderRepository.save(order);
        List<Long> orderIds = savedOrder.getProductIds();
        customerService.updateCustomerOrderIds(customerId, orderIds);
        return savedOrder;
    }

    @Override
    public Orders getOrderById(Long id) {
        Optional<Orders> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new InvalidOrderIdException("Order not found", id);
        }
        return order.get();
    }

    @Override
    public void deleteOrderById(Long id) {
        Optional<Orders> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new InvalidOrderIdException("Order not found", id);
        }
        orderRepository.deleteById(id);
    }

    @Override
    public Orders updateOrder(Long id, OrderRequestDto orderRequestDto) {
        Orders order = new Orders();
        order.setCustomerId(orderRequestDto.getCustomerId());
        order.setProductIds(orderRequestDto.getProductIds());

        List<Long> productIds = orderRequestDto.getProductIds();
        Optional<Orders> getOrder = orderRepository.findById(id);
        if (getOrder.isEmpty()) {
            throw new InvalidOrderIdException("Order not found", id);
        }
        return orderRepository.save(order);
    }

    @Override
    public List<Orders> getOrderHistoryByCustomerId(Long id) {
        Customer customer = customerService.getCustomerById(id);
        List<Long> orderIds = customer.getOrderIds();
        System.out.println(orderIds);
        List<Orders> orders = new ArrayList<>();
        for (int j=0; j<orderIds.size(); j++) {
            Orders order = getOrderById(orderIds.get(j));
            orders.add(order);
        }
        if (orders.isEmpty()) {
            throw new NoOrderHistoryFoundException("No order history found", id);
        }
        return orders;
    }

    @Override
    public OrderStatus getOrderStatusById(Long id) {
        Optional<Orders> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new InvalidOrderIdException("Order not found", id);
        }
        return order.get().getOrderStatus();
    }

    @Override
    public OrderConfirmation getOrderConfirmationById(Long id) {
        Optional<Orders> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new InvalidOrderIdException("Order not found", id);
        }
        return order.get().getOrderConfirmation();
    }
}
