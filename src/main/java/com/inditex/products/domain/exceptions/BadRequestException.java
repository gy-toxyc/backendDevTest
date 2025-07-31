package com.inditex.products.domain.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("Bad Request");
    }
}
