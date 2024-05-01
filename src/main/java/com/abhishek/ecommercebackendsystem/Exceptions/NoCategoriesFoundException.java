package com.abhishek.ecommercebackendsystem.Exceptions;

public class NoCategoriesFoundException extends RuntimeException {
    public NoCategoriesFoundException(String message) {
        super(message);
    }
}
