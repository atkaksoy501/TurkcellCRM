package com.turkcell.crm.searchService.business.abstracts;
import com.turkcell.crm.searchService.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ProductService {

    void add(Product product);
    Page<Product> searchProducts(
            Optional<String> name,
            Optional<Integer> id,
            Optional<Double> price,
            Optional<Integer> stockAmount,
            Optional<String> description,
            Pageable pageable
    );
}
