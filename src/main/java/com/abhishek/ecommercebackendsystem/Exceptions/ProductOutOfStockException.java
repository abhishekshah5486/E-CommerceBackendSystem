package com.abhishek.ecommercebackendsystem.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOutOfStockException extends RuntimeException {
    private Long id;
    public ProductOutOfStockException(String message, Long id) {
        super(message);
        this.id = id;
    }
}
