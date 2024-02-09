package com.ecommerce.registeruserapi.exception;

public class AlreadyExistException extends RuntimeException {

    public AlreadyExistException(String message) {
        super(message);
    }

    public AlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyExistException(Boolean status, String message, Throwable cause) {
        super(message, cause, status, status);
    }
}
