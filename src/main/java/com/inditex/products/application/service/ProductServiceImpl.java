package com.inditex.products.application.service;

import com.inditex.products.application.dto.out.ProductDetailODTO;
import com.inditex.products.application.mapper.ProductServiceMapper;
import com.inditex.products.domain.repository.ProductApiFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductServiceMapper mapper;
    private final ProductApiFacade productApi;

    @Override
    public List<ProductDetailODTO> getSimilarProducts(String productId) {
        return productApi.getSimilarIds(productId).stream()
                .map(productApi::getProductDetail)
                .map(mapper::toODTO)
                .toList();
    }
}
