package com.inditex.products.application.dto.out;

import lombok.Builder;

@Builder
public record ProductDetailODTO(
        String id,
        String name,
        Number price,
        Boolean availability
) { }