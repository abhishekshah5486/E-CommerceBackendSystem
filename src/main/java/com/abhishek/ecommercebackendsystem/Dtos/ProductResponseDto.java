package com.abhishek.ecommercebackendsystem.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private String productLink;
    private String title;
    private double price;
}
