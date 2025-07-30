package com.inditex.products.infrastructure.external.feign.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ProductDetailFeignDTO(
        @NotBlank
        String id,
        @NotBlank
        String name,
        Number price,
        Boolean availability
) { }