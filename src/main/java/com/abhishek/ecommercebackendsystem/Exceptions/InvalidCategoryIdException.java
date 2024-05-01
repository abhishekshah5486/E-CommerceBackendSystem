package com.abhishek.ecommercebackendsystem.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidCategoryIdException extends RuntimeException {
    private Long id;
    public InvalidCategoryIdException(String message, Long id) {
        super(message);
        this.id = id;
    }
}
