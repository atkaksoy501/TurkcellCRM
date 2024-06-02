package com.turkcell.crm.searchService.dataAccess.abstracts;

import com.turkcell.crm.searchService.entities.concretes.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatalogRepository extends MongoRepository<Catalog, Integer> {

    Catalog findByName(String name);

}
