package com.inditex.products.domain.model;

import lombok.Builder;

@Builder
public record ProductDetailMO(
        String id,
        String name,
        Number price,
        Boolean availability
) { }