package com.inditex.products.domain.exceptions;

public class InternalServerException extends RuntimeException {
    public InternalServerException() {
        super("Internal Server Error");
    }
}
