package com.inditex.products.infrastructure.external.feign.mapper;

import com.inditex.products.domain.model.ProductDetailMO;
import com.inditex.products.infrastructure.external.feign.dto.ProductDetailFeignDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductFeignFacadeMapper {
    ProductDetailMO toMO(ProductDetailFeignDTO productDetail);
}
