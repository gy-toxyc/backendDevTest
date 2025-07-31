package com.inditex.products.application.mapper;

import com.inditex.products.infrastructure.api.mapper.ProductControllerMapperImpl;
import com.inditex.products.stubs.ProductStubs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class ProductServiceMapperImplTest {
    @InjectMocks
    private ProductServiceMapperImpl mapper;

    @Test
    @DisplayName("[PRODUCT_SERVICE_MAPPER] - Test successful map from MO to ODTO.")
    void shouldMapToODTO() {
        // Given
        final var productDetailMO = ProductStubs.mockProductDetailMO();
        final var productDetailODTO = ProductStubs.mockProductDetailODTO();

        // Then
        final var result = mapper.toODTO(productDetailMO);

        // Verify
        assertEquals(productDetailODTO, result);
    }

    @Test
    @DisplayName("[PRODUCT_SERVICE_MAPPER] - Test unsuccessful map from MO to ODTO due to null parameter.")
    void shouldNotMapToODTO() {
        // Given & Then
        final var result = mapper.toODTO(null);

        // Verify
        assertNull(result);
    }
}
