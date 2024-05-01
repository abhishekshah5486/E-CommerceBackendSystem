package com.abhishek.ecommercebackendsystem.Models;

import jakarta.persistence.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double price;
    private double rating;
//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    private Category category;
//    @OneToOne(fetch = FetchType.LAZY)
    @OneToOne
    private Inventory inventory;
    private ProductAvailability productAvailability;
}
