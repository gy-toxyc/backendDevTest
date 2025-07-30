package com.inditex.products.domain.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Not Found");
    }
}
