package com.turkcell.crm.catalogService.catalogService.business.concretes;

import com.turkcell.crm.catalogService.catalogService.business.abstracts.CatalogService;
import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.catalog.CreateCatalogRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.catalog.UpdateCatalogRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.CreatedCatalogResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.GetAllCatalogsResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.GetCatalogResponseById;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.UpdatedCatalogResponse;
import com.turkcell.crm.catalogService.catalogService.core.mapping.ModelMapperService;
import com.turkcell.crm.catalogService.catalogService.dataAccess.abstracts.CatalogRepository;
import com.turkcell.crm.catalogService.catalogService.entities.concretes.Catalog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class CatalogManager implements CatalogService {

    private final ModelMapperService modelMapperService;
    private final CatalogRepository catalogRepository;

    @Override
    public CreatedCatalogResponse add(CreateCatalogRequest createCatalogRequest) {
        Catalog catalog = this.modelMapperService.forRequest().map(createCatalogRequest, Catalog.class);
        catalog.setCreatedDate(LocalDateTime.now());
        Catalog savedCatalog = catalogRepository.save(catalog);
        return this.modelMapperService.forResponse().map(savedCatalog, CreatedCatalogResponse.class);
    }

    @Override
    public List<GetAllCatalogsResponse> getAll() {
        List<Catalog> catalogs = catalogRepository.findAll().stream().filter(Catalog::isActive).toList();
        return catalogs.stream().map(
                catalog -> this.modelMapperService.forResponse().map(catalog, GetAllCatalogsResponse.class)
        ).toList();
    }

    @Override
    public GetCatalogResponseById getById(int id) {
        Catalog catalog = catalogRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(catalog, GetCatalogResponseById.class);
    }

    @Override
    public UpdatedCatalogResponse updateCatalog(UpdateCatalogRequest updateCatalogRequest) {
        Catalog catalog = catalogRepository.findById(updateCatalogRequest.getId()).orElse(null);
        modelMapperService.forUpdate().map(updateCatalogRequest, catalog);
        catalog.setUpdatedDate(LocalDateTime.now());
        Catalog savedCatalog = catalogRepository.save(catalog);
        return this.modelMapperService.forResponse().map(savedCatalog, UpdatedCatalogResponse.class);
    }

    @Override
    public void delete(int id) {
        Catalog catalog = catalogRepository.findById(id).orElse(null);
        catalog.setActive(false);
        catalog.setDeletedDate(LocalDateTime.now());
        catalogRepository.save(catalog);
    }
}
