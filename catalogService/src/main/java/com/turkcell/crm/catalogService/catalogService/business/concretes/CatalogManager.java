package com.turkcell.crm.catalogService.catalogService.business.concretes;

import com.turkcell.crm.catalogService.catalogService.business.abstracts.CatalogService;
import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.catalog.CreateCatalogRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.catalog.UpdateCatalogRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.CreatedCatalogResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.GetAllCatalogsResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.GetCatalogResponseById;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.UpdatedCatalogResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CatalogManager implements CatalogService {
    @Override
    public CreatedCatalogResponse add(CreateCatalogRequest createCatalogRequest) {
        return null;
    }

    @Override
    public List<GetAllCatalogsResponse> getAll() {
        return null;
    }

    @Override
    public GetCatalogResponseById getById(int id) {
        return null;
    }

    @Override
    public UpdatedCatalogResponse updateCatalog(UpdateCatalogRequest updateCatalogRequest) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
