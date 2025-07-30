package com.inditex.products.infrastructure.external.feign;

import com.inditex.products.domain.exceptions.ExternalServerException;
import com.inditex.products.domain.exceptions.InternalServerException;
import com.inditex.products.domain.exceptions.ResourceNotFoundException;
import com.inditex.products.domain.model.ProductDetailMO;
import com.inditex.products.domain.repository.ProductApiFacade;
import com.inditex.products.infrastructure.external.feign.mapper.ProductFeignFacadeMapper;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
@AllArgsConstructor
public class ProductApiFacadeImpl implements ProductApiFacade {
    private final ProductFeignClient feignClient;
    private final ProductFeignFacadeMapper mapper;

    @Override
    public ProductDetailMO getProductDetail(String productId) {
        try {
            return mapper.toMO(feignClient.getProductDetail(productId));
        } catch (FeignException.NotFound e) {
            throw new ResourceNotFoundException("Not Found");
        } catch (FeignException e) {
            throw new ExternalServerException("External Server Error");
        } catch (Exception e) {
            throw new InternalServerException("Internal Server Error");
        }
    }

    @Override
    public List<String> getSimilarIds(String productId) {
        try {
            return feignClient.getSimilarIds(productId);
        } catch (FeignException.NotFound e) {
            throw new ResourceNotFoundException("Not Found");
        } catch (FeignException e) {
            throw new ExternalServerException("External Server Error");
        } catch (Exception e) {
            throw new InternalServerException("Internal Server Error");
        }
    }
}
