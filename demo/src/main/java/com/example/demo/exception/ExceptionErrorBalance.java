package com.example.demo.exception;

public class ExceptionErrorBalance extends RuntimeException {

    public ExceptionErrorBalance() {
    }

    public ExceptionErrorBalance(final String message) {
        super(message);
    }

    public ExceptionErrorBalance(final String message, final Throwable cause) {
        super(message, cause);
    }
}
