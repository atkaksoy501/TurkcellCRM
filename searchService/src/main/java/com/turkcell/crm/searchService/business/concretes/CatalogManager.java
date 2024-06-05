package com.turkcell.crm.searchService.business.concretes;

import com.turkcell.crm.searchService.business.abstracts.CatalogService;
import com.turkcell.crm.searchService.dataAccess.abstracts.CatalogRepository;
import com.turkcell.crm.searchService.entities.concretes.Catalog;
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
public class CatalogManager implements CatalogService {

    private final CatalogRepository catalogRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public void add(Catalog catalog) {
        catalogRepository.save(catalog);
    }

    @Override
    public Page<Catalog> searchCatalogs(
            Optional<String> name,
            Optional<Integer> id,
            Pageable pageable
    ) {
        Query query = new Query();

        name.ifPresent(n -> query.addCriteria(Criteria.where("name").regex("^" + n, "i")));
        id.ifPresent(i -> query.addCriteria(Criteria.where("id").is(i)));

        long total = mongoTemplate.count(query, Catalog.class);

        List<Catalog> products = mongoTemplate.find(query.with(pageable), Catalog.class);

        return new PageImpl<>(products, pageable, total);
    }
}
