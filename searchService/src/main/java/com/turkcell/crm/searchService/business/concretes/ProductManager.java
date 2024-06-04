package com.turkcell.crm.searchService.business.concretes;

import com.turkcell.crm.searchService.business.abstracts.ProductService;
import com.turkcell.crm.searchService.dataAccess.abstracts.ProductRepository;
import com.turkcell.crm.searchService.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final MongoTemplate mongoTemplate;


    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> searchProducts(
            Optional<String> name,
            Optional<Integer> id,
            Optional<Double> price,
            Optional<Integer> stockAmount,
            Optional<String> description,
            Pageable pageable
    ) {
        Query query = new Query();
        name.ifPresent(n -> query.addCriteria(Criteria.where("name").regex("^" + n, "i")));
        id.ifPresent(i -> query.addCriteria(Criteria.where("id").is(i)));
        price.ifPresent(p -> query.addCriteria(Criteria.where("price").is(p)));
        stockAmount.ifPresent(s -> query.addCriteria(Criteria.where("stockAmount").is(s)));
        description.ifPresent(d -> query.addCriteria(Criteria.where("description").regex("^" + d, "i")));
        long total = mongoTemplate.count(query, Product.class);
        List<Product> products = mongoTemplate.find(query.with(pageable), Product.class);
        return new PageImpl<>(products, pageable, total);
    }


}
