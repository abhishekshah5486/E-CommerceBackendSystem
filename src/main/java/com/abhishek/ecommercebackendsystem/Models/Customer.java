package com.abhishek.ecommercebackendsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@AllArgsConstructor
public class Customer extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phone;
    private LocalDate registrationDate;
    @OneToMany
    List<Order> orders;

    public Customer(String name, String email, String username, String password, String address, String phone) {
        super();
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }
}
