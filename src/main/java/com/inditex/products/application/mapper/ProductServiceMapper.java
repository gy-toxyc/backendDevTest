package com.inditex.products.application.mapper;

import com.inditex.products.application.dto.out.ProductDetailODTO;
import com.inditex.products.domain.model.ProductDetailMO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductServiceMapper {
    ProductDetailODTO toODTO(ProductDetailMO productDetail);
}
