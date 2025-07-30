package com.inditex.products.domain.exceptions;

public class ExternalServerException extends RuntimeException {
    public ExternalServerException() {
        super("External Server Error");
    }
}
