package com.turkcell.crm.searchService.business.concretes;

import com.turkcell.crm.searchService.business.abstracts.CatalogService;
import com.turkcell.crm.searchService.dataAccess.abstracts.CatalogRepository;
import com.turkcell.crm.searchService.entities.concretes.Catalog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CatalogManager implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Override
    public void add(Catalog catalog) {catalogRepository.save(catalog);
    }
}
