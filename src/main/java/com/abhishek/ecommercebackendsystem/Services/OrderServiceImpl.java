package com.abhishek.ecommercebackendsystem.Services;

import com.abhishek.ecommercebackendsystem.Controllers.CustomerController;
import com.abhishek.ecommercebackendsystem.Dtos.OrderRequestDto;
import com.abhishek.ecommercebackendsystem.Exceptions.InvalidOrderIdException;
import com.abhishek.ecommercebackendsystem.Exceptions.ProductOutOfStockException;
import com.abhishek.ecommercebackendsystem.Models.Customer;
import com.abhishek.ecommercebackendsystem.Models.Orders;
import com.abhishek.ecommercebackendsystem.Models.Product;
import com.abhishek.ecommercebackendsystem.Models.ProductAvailability;
import com.abhishek.ecommercebackendsystem.Repositories.CustomerRepository;
import com.abhishek.ecommercebackendsystem.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ProductService productService;
    private CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductService productService, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.customerRepository = customerRepository;
    }

    @Override
    public Orders createOrder(OrderRequestDto orderRequestDto) {
        Orders order = new Orders();
        order.setCustomerId(orderRequestDto.getCustomerId());
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
        Orders orderCreated =  orderRepository.save(order);
        Optional<Customer> customer = customerRepository.findById(orderCreated.getCustomerId());
        customer.get().getOrderIds().add(orderCreated.getOrderId());

        return orderCreated;
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
}
