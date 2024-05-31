package com.turkcell.crm.catalogService.catalogService.api.controllers;

import com.turkcell.crm.catalogService.catalogService.business.abstracts.CatalogService;
import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.catalog.CreateCatalogRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.catalog.UpdateCatalogRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.CreatedCatalogResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.GetAllCatalogsResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.GetCatalogResponseById;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog.UpdatedCatalogResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/catalogs")
public class CatalogsController {
    private final CatalogService catalogService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCatalogResponse add(@Valid @RequestBody CreateCatalogRequest createCatalogRequest) {
        return catalogService.add(createCatalogRequest);
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCatalogsResponse> getAll() {
        return catalogService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCatalogResponseById getById(@PathVariable int id) {
        return catalogService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        catalogService.delete(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCatalogResponse update(@Valid @RequestBody UpdateCatalogRequest updateCatalogRequest) {
        return catalogService.updateCatalog(updateCatalogRequest);
    }
}
