package com.abhishek.ecommercebackendsystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long customerId;

    @ElementCollection
    private List<Long> productIds = new ArrayList<>();
    private double totalAmount;
    private OrderStatus orderStatus;

    @Column(name = "ordered_date")
    private LocalDate orderedDate;

    @PrePersist
    protected void onCreate() {
        orderedDate = LocalDate.now();
    }
    private OrderConfirmation orderConfirmation = OrderConfirmation.CONFIRMED; // For testing purposes only.
    // Assuming the payment has been made by the customer successfully.
}
