package com.inditex.products.infrastructure.external.feign;

import com.inditex.products.domain.exceptions.ExternalServerException;
import com.inditex.products.domain.exceptions.ResourceNotFoundException;
import com.inditex.products.infrastructure.external.feign.mapper.ProductApiFacadeMapper;
import com.inditex.products.stubs.ProductStubs;
import feign.FeignException;
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
public class ProductApiFacadeImplTest {
    @Mock
    private ProductFeignClient feignClient;

    @Mock
    private ProductApiFacadeMapper mapper;

    @InjectMocks
    private ProductApiFacadeImpl facade;

    @Test
    @DisplayName("[PRODUCT_API_FACADE] - Test successful retrieval of Similar Product IDs.")
    void shouldReturnSimilarProductIDs() {
        // When
        when(feignClient.getSimilarIds(ProductStubs.ID)).thenReturn(List.of(ProductStubs.SIMILAR_ID));

        // Then
        final var result = facade.getSimilarIds(ProductStubs.ID);

        // Verify
        verify(feignClient).getSimilarIds(ProductStubs.ID);

        assertEquals(ProductStubs.SIMILAR_ID, result.getFirst());
    }

    @Test
    @DisplayName("[PRODUCT_API_FACADE] - Test unsuccessful retrieval of Similar Products IDs as the API retrieves a Not Found.")
    void shouldNotReturnSimilarIds404() {
        // Given
        final var feignException = mock(FeignException.NotFound.class);

        // When
        when(feignClient.getSimilarIds(ProductStubs.ID)).thenThrow(feignException);

        // Then & Verify
        assertThrows(
                ResourceNotFoundException.class,
                () -> facade.getSimilarIds(ProductStubs.ID)
        );

        verify(feignClient).getSimilarIds(ProductStubs.ID);
        verifyNoMoreInteractions(feignClient);
    }

    @Test
    @DisplayName("[PRODUCT_API_FACADE] - Test unsuccessful retrieval of Similar Products IDs as the API doesn't respond.")
    void shouldNotReturnSimilarIds502() {
        // Given
        final var feignException = mock(FeignException.class);

        // When
        when(feignClient.getSimilarIds(ProductStubs.ID)).thenThrow(feignException);

        // Then & Verify
        assertThrows(
                ExternalServerException.class,
                () -> facade.getSimilarIds(ProductStubs.ID)
        );

        verify(feignClient).getSimilarIds(ProductStubs.ID);
        verifyNoMoreInteractions(feignClient);
    }

    @Test
    @DisplayName("[PRODUCT_API_FACADE] - Test successful retrieval of Product Details.")
    void shouldReturnProductDetails() {
        // Given
        final var productDetailMO = ProductStubs.mockProductDetailMO();
        final var productDetailFeignDTO = ProductStubs.mockProductDetailFeignDTO();

        // When
        when(feignClient.getProductDetail(ProductStubs.ID)).thenReturn(productDetailFeignDTO);
        when(mapper.toMO(productDetailFeignDTO)).thenReturn(productDetailMO);

        // Then
        final var result = facade.getProductDetail(ProductStubs.ID);

        // Verify
        verify(feignClient).getProductDetail(ProductStubs.ID);
        verify(mapper).toMO(productDetailFeignDTO);
        verifyNoMoreInteractions(feignClient, mapper);

        assertEquals(productDetailMO, result);
    }

    @Test
    @DisplayName("[PRODUCT_API_FACADE] - Test unsuccessful retrieval of Product Details as the API retrieves a Not Found.")
    void shouldNotReturnProductDetails404() {
        // Given
        final var feignException = mock(FeignException.NotFound.class);

        // When
        when(feignClient.getProductDetail(ProductStubs.ID)).thenThrow(feignException);

        // Then & Verify
        assertThrows(
                ResourceNotFoundException.class,
                () -> facade.getProductDetail(ProductStubs.ID)
        );

        verify(feignClient).getProductDetail(ProductStubs.ID);
        verifyNoMoreInteractions(feignClient);
    }

    @Test
    @DisplayName("[PRODUCT_API_FACADE] - Test unsuccessful retrieval of Product Details as the API doesn't respond.")
    void shouldNotReturnProductDetails502() {
        // Given
        final var feignException = mock(FeignException.class);

        // When
        when(feignClient.getProductDetail(ProductStubs.ID)).thenThrow(feignException);

        // Then & Verify
        assertThrows(
                ExternalServerException.class,
                () -> facade.getProductDetail(ProductStubs.ID)
        );

        verify(feignClient).getProductDetail(ProductStubs.ID);
        verifyNoMoreInteractions(feignClient);
    }
}
