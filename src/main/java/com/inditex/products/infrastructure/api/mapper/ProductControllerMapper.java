package com.inditex.products.infrastructure.api.mapper;

import com.inditex.products.application.dto.out.ProductDetailODTO;
import com.inditex.products.infrastructure.api.dto.out.ProductDetailRSDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductControllerMapper {
    ProductDetailRSDTO toRSDTO(ProductDetailODTO productDetail);
}
