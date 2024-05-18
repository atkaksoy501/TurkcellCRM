package com.turkcell.crm.catalogService.catalogService.business.abstracts;

import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.catalog.CreateCatalogRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.catalog.UpdateCatalogRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.CreatedCatalogResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.GetAllCatalogsResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.GetCatalogResponseById;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.UpdatedCatalogResponse;

import java.util.List;

public interface CatalogService {
    CreatedCatalogResponse add(CreateCatalogRequest createCatalogRequest);
    List<GetAllCatalogsResponse> getAll();
    GetCatalogResponseById getById(int id);
    UpdatedCatalogResponse updateCatalog(UpdateCatalogRequest updateCatalogRequest);
    void delete(int id);
}
