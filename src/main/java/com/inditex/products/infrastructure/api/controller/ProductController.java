package com.inditex.products.infrastructure.api.controller;

import com.inditex.products.infrastructure.api.dto.out.ProductDetailRSDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/product")
public interface ProductController {
    @GetMapping("/{productId}/similar")
    ResponseEntity<List<ProductDetailRSDTO>> getSimilarProducts(@PathVariable("productId") String productId);
}