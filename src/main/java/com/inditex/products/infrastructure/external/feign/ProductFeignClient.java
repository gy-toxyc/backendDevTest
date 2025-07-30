package com.inditex.products.infrastructure.external.feign;

import com.inditex.products.infrastructure.external.feign.dto.ProductDetailFeignDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "productAPI", url = "http://localhost:3001")
public interface ProductFeignClient {
    @GetMapping("/product/{productId}")
    ProductDetailFeignDTO getProductDetail(@PathVariable("productId") String productId);

    @GetMapping("/product/{productId}/similarids")
    List<String> getSimilarIds(@PathVariable("productId") String productId);
}
