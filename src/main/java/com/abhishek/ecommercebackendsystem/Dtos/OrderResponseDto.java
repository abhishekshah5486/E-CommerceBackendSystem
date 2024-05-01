package com.abhishek.ecommercebackendsystem.Dtos;

import com.abhishek.ecommercebackendsystem.Models.OrderStatus;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private Long orderId;
    private Long customerId;
    private double totalAmount;
    private OrderStatus orderStatus;
    private LocalDate orderDate;
    @ElementCollection
    private List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
}
