package com.inditex.products.infrastructure.api.controller;

import com.inditex.products.application.service.ProductService;
import com.inditex.products.infrastructure.api.dto.out.ProductDetailRSDTO;
import com.inditex.products.infrastructure.api.mapper.ProductControllerMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService service;
    private final ProductControllerMapper mapper;

    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<ProductDetailRSDTO>> getSimilarProducts(
            @PathVariable("productId") String productId
    ) {
        final var products = service.getSimilarProducts(productId)
                .stream()
                .map(mapper::toRSDTO)
                .toList();

        return ResponseEntity.ok(products);
    }
}