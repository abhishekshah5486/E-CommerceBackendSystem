package com.abhishek.ecommercebackendsystem.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidCustomerIdException extends RuntimeException {
    private Long id;
    public InvalidCustomerIdException(String message, Long id) {
        super(message);
        this.id = id;
    }
}
