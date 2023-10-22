package com.dona.blogDemo.exception;

public class WrongDetailsException extends RuntimeException {
    public WrongDetailsException(String message) {
        super(message);
    }
}
