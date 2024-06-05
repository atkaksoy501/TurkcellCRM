package com.turkcell.crm.searchService.business.abstracts;

import com.turkcell.crm.searchService.entities.concretes.Catalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface CatalogService {

    void add(Catalog catalog);

    Page<Catalog> searchCatalogs(
            Optional<String> name,
            Optional<Integer> id,
            Pageable pageable
    );

}
