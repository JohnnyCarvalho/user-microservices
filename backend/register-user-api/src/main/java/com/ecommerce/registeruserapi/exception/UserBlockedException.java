package com.ecommerce.registeruserapi.exception;

public class UserBlockedException extends RuntimeException {

    public UserBlockedException(String message) {
        super(message);
    }

    public UserBlockedException(String message, Throwable cause) {
        super(message, cause);
    }
}
