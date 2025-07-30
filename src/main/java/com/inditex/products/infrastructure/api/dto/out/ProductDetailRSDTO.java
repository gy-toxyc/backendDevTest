package com.inditex.products.infrastructure.api.dto.out;

import lombok.Builder;

@Builder
public record ProductDetailRSDTO(
        String id,
        String name,
        Number price,
        Boolean availability
) { }