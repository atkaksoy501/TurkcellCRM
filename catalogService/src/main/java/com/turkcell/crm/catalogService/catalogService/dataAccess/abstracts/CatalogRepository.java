package com.turkcell.crm.catalogService.catalogService.dataAccess.abstracts;

import com.turkcell.crm.catalogService.catalogService.entities.concretes.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
}
