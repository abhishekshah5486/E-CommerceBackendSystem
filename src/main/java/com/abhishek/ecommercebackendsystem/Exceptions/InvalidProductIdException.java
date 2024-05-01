package com.abhishek.ecommercebackendsystem.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidProductIdException extends RuntimeException {
    private Long id;
    public InvalidProductIdException(String message, Long id) {
        super(message);
        this.id = id;
    }
}
