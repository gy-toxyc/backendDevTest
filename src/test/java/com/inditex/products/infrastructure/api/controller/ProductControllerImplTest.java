package com.inditex.products.infrastructure.api.controller;

import com.inditex.products.application.mapper.ProductServiceMapper;
import com.inditex.products.application.service.ProductService;
import com.inditex.products.application.service.ProductServiceImpl;
import com.inditex.products.domain.exceptions.BadRequestException;
import com.inditex.products.domain.exceptions.ResourceNotFoundException;
import com.inditex.products.domain.repository.ProductApiFacade;
import com.inditex.products.infrastructure.api.mapper.ProductControllerMapper;
import com.inditex.products.stubs.ProductStubs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductControllerImplTest {
    @Mock
    private ProductService service;

    @Mock
    private ProductControllerMapper mapper;

    @InjectMocks
    private ProductControllerImpl controller;

    @Test
    @DisplayName("[PRODUCT_CONTROLLER] - Test successful retrieval of Similar Products.")
    void shouldReturnSimilarProducts() {
        // Given
        final var similarProductDetailODTO = ProductStubs.mockProductDetailODTO();
        final var similarProductDetailRSDTO = ProductStubs.mockProductDetailRSDTO();

        // When
        when(service.getSimilarProducts(ProductStubs.ID)).thenReturn(List.of(similarProductDetailODTO));
        when(mapper.toRSDTO(similarProductDetailODTO)).thenReturn(similarProductDetailRSDTO);

        // Then
        final var result = controller.getSimilarProducts(ProductStubs.ID);

        // Verify
        verify(service).getSimilarProducts(ProductStubs.ID);
        verify(mapper).toRSDTO(similarProductDetailODTO);

        assertEquals(similarProductDetailRSDTO, result.getBody().getFirst());
    }

    @Test
    @DisplayName("[PRODUCT_CONTROLLER] - Test unsuccessful retrieval of Similar Products due to a Bad Request.")
    void shouldNotReturnSimilarProducts400() {
        // When, Then & Verify
        assertThrows(
                BadRequestException.class,
                () -> controller.getSimilarProducts("wrong-id")
        );
    }
}
