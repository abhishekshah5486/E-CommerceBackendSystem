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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @PrePersist
    protected void onCreate() {
        registrationDate = LocalDate.now();
    }

    @ElementCollection
    private List<Long> orderIds = new ArrayList<>();
}
