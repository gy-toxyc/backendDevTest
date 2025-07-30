package com.inditex.products.domain.repository;

import com.inditex.products.domain.model.ProductDetailMO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductApiFacade {
    ProductDetailMO getProductDetail(String productId);
    List<String> getSimilarIds(String productId);
}
