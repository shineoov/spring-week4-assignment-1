package com.codesoom.assignment.application;

import com.codesoom.assignment.domain.Product;
import com.codesoom.assignment.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("ProductQueryServiceTest 클래스")
class ProductQueryServiceTest {

    @InjectMocks
    ProductQueryService productQueryService;

    @Mock
    ProductRepository productRepository;

    @Nested
    @DisplayName("getProducts 메소드는")
    class Describe_getProducts {

        @Nested
        @DisplayName("주어진 상품 수 만큼")
        class Context_hasProducts {

            final int givenCount = 10;

            @BeforeEach
            void setUp() {
                Iterable<Product> products = LongStream.rangeClosed(1, givenCount)
                        .mapToObj(Product::new)
                        .collect(Collectors.toList());

                given(productRepository.findAll()).willReturn(products);
            }

            @Test
            @DisplayName("상품 목록을 리턴한다.")
            void it_return_products() {

                List<Product> products = productQueryService.getProducts();

                assertThat(products).hasSize(givenCount);
            }
        }
    }
}
