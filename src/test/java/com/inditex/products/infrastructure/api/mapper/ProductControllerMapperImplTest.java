package com.inditex.products.infrastructure.api.mapper;

import com.inditex.products.application.service.ProductService;
import com.inditex.products.domain.exceptions.BadRequestException;
import com.inditex.products.infrastructure.api.controller.ProductControllerImpl;
import com.inditex.products.stubs.ProductStubs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerMapperImplTest {
    @InjectMocks
    private ProductControllerMapperImpl mapper;

    @Test
    @DisplayName("[PRODUCT_CONTROLLER_MAPPER] - Test successful map from ODTO to RSDTO.")
    void shouldMapToRSDTO() {
        // Given
        final var productDetailODTO = ProductStubs.mockProductDetailODTO();
        final var productDetailRSDTO = ProductStubs.mockProductDetailRSDTO();

        // Then
        final var result = mapper.toRSDTO(productDetailODTO);

        // Verify
        assertEquals(productDetailRSDTO, result);
    }

    @Test
    @DisplayName("[PRODUCT_CONTROLLER_MAPPER] - Test unsuccessful map from ODTO to RSDTO due to null parameter.")
    void shouldNotMapToRSDTO() {
        // Given & Then
        final var result = mapper.toRSDTO(null);

        // Verify
        assertNull(result);
    }
}
