package com.inditex.products.stubs;

import com.inditex.products.application.dto.out.ProductDetailODTO;
import com.inditex.products.domain.model.ProductDetailMO;
import com.inditex.products.infrastructure.api.dto.out.ProductDetailRSDTO;
import com.inditex.products.infrastructure.external.feign.dto.ProductDetailFeignDTO;

public record ProductStubs() {
    public static final String ID = "1";
    public static final String SIMILAR_ID = "2";

    public static ProductDetailFeignDTO mockProductDetailFeignDTO() {
        return ProductDetailFeignDTO.builder()
                .id(SIMILAR_ID)
                .name("Product Name")
                .price(100.0)
                .availability(Boolean.TRUE)
                .build();
    }

    public static ProductDetailMO mockProductDetailMO() {
        return ProductDetailMO.builder()
                .id(SIMILAR_ID)
                .name("Product Name")
                .price(100.0)
                .availability(Boolean.TRUE)
                .build();
    }

    public static ProductDetailODTO mockProductDetailODTO() {
        return ProductDetailODTO.builder()
                .id(SIMILAR_ID)
                .name("Product Name")
                .price(100.0)
                .availability(Boolean.TRUE)
                .build();
    }

    public static ProductDetailRSDTO mockProductDetailRSDTO() {
        return ProductDetailRSDTO.builder()
                .id(SIMILAR_ID)
                .name("Product Name")
                .price(100.0)
                .availability(Boolean.TRUE)
                .build();
    }
}
