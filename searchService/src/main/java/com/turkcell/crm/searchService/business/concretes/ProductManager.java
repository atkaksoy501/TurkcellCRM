package com.turkcell.crm.searchService.business.concretes;

import com.turkcell.crm.searchService.business.abstracts.ProductService;
import com.turkcell.crm.searchService.dataAccess.abstracts.ProductRepository;
import com.turkcell.crm.searchService.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

}
