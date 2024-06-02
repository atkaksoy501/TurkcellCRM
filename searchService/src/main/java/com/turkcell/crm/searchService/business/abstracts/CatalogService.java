package com.turkcell.crm.searchService.business.abstracts;

import com.turkcell.crm.common.events.catalog.CreateCatalogEvent;
import com.turkcell.crm.searchService.entities.concretes.Catalog;


public interface CatalogService {

    void add(Catalog Catalog);

}
