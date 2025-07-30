package com.inditex.products.application.service;

import com.inditex.products.application.dto.out.ProductDetailODTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductService {
    List<ProductDetailODTO> getSimilarProducts(String productId);
}