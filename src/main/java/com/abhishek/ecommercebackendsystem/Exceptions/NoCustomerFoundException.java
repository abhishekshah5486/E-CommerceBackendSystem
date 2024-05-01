package com.abhishek.ecommercebackendsystem.Exceptions;

public class NoCustomerFoundException extends RuntimeException {
    public NoCustomerFoundException(String message) {
        super(message);
    }
}
