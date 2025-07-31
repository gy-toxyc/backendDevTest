package com.inditex.products.application.service;

import com.inditex.products.application.mapper.ProductServiceMapper;
import com.inditex.products.domain.repository.ProductApiFacade;
import com.inditex.products.stubs.ProductStubs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    @Mock
    private ProductServiceMapper mapper;

    @Mock
    private ProductApiFacade productApi;

    @InjectMocks
    private ProductServiceImpl service;

    @Test
    @DisplayName("[PRODUCT_SERVICE] - Test successful retrieval of Similar Products.")
    void shouldReturnSimilarProducts() {
        // Given
        final var similarProductDetailMO = ProductStubs.mockProductDetailMO();
        final var similarProductDetailODTO = ProductStubs.mockProductDetailODTO();

        // When
        when(productApi.getSimilarIds(ProductStubs.ID)).thenReturn(List.of(ProductStubs.SIMILAR_ID));
        when(productApi.getProductDetail(ProductStubs.SIMILAR_ID)).thenReturn(similarProductDetailMO);
        when(mapper.toODTO(similarProductDetailMO)).thenReturn(similarProductDetailODTO);

        // Then
        final var result = service.getSimilarProducts(ProductStubs.ID);

        // Verify
        verify(productApi).getSimilarIds(ProductStubs.ID);
        verify(productApi).getProductDetail(ProductStubs.SIMILAR_ID);
        verify(mapper).toODTO(similarProductDetailMO);

        assertEquals(similarProductDetailODTO, result.getFirst());
    }
}
