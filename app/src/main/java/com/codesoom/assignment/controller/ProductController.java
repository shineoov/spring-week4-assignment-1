package com.codesoom.assignment.controller;

import com.codesoom.assignment.application.ProductService;
import com.codesoom.assignment.domain.Product;
import com.codesoom.assignment.dto.ProductSaveDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 상품에 대한 HTTP 요청을 처리합니다.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 상품 전체 목록을 리턴합니다.
     */
    @GetMapping
    public List<Product> list() {
        return productService.getProducts();
    }

    /**
     *  상품을 생성하고 리턴합니다.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Product save(ProductSaveDto productSaveDto) {
        return productService.saveProduct(productSaveDto);
    }
}