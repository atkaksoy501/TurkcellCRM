package com.turkcell.crm.searchService.api.controllers;

import com.turkcell.crm.searchService.business.abstracts.ProductService;
import com.turkcell.crm.searchService.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductsController {
    private final ProductService productService;

    @GetMapping("/search")
    public Page<Product> searchProducts(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Integer> id,
            @RequestParam Optional<Double> price,
            @RequestParam Optional<Integer> stockAmount,
            @RequestParam Optional<String> description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);
        return productService.searchProducts(
                name, id, price, stockAmount, description, pageable);
    }
}
