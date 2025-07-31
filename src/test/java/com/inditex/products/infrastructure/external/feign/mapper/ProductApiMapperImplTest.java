package com.inditex.products.infrastructure.external.feign.mapper;

import com.inditex.products.application.mapper.ProductServiceMapperImpl;
import com.inditex.products.stubs.ProductStubs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class ProductApiMapperImplTest {
    @InjectMocks
    private ProductApiFacadeMapperImpl mapper;

    @Test
    @DisplayName("[PRODUCT_API_FACADE_MAPPER] - Test successful map from FeignDTO to MO.")
    void shouldMapToMO() {
        // Given
        final var productDetailFeignDTO = ProductStubs.mockProductDetailFeignDTO();
        final var productDetailMO = ProductStubs.mockProductDetailMO();

        // Then
        final var result = mapper.toMO(productDetailFeignDTO);

        // Verify
        assertEquals(productDetailMO, result);
    }

    @Test
    @DisplayName("[PRODUCT_API_FACADE_MAPPER] - Test unsuccessful map from FeignDTO to MO due to null parameter.")
    void shouldNotMapToMO() {
        // Given & Then
        final var result = mapper.toMO(null);

        // Verify
        assertNull(result);
    }
}
