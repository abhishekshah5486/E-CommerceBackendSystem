package com.abhishek.ecommercebackendsystem.Exceptions;

public class NoOrderHistoryFoundException extends RuntimeException {
    private Long customerId;
    public NoOrderHistoryFoundException(String message, Long customerId) {
        super(message);
        this.customerId = null;
    }
}
