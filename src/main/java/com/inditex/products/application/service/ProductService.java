package com.inditex.products.application.service;

import com.inditex.products.application.dto.out.ProductDetailODTO;

import java.util.List;

public interface ProductService {
    List<ProductDetailODTO> getSimilarProducts(String productId);
}