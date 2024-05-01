package com.abhishek.ecommercebackendsystem.Exceptions;

public class NoProductsFoundException extends RuntimeException {
    public NoProductsFoundException(String message) {
        super(message);
    }
}
