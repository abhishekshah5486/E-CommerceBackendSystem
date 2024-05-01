package com.abhishek.ecommercebackendsystem.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidOrderIdException extends RuntimeException {
    private Long id;
    public InvalidOrderIdException(String message, Long id) {
        super(message);
        this.id = id;
    }
}
