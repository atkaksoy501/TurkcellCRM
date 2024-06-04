package com.turkcell.crm.searchService.api.controllers;

import com.turkcell.crm.searchService.business.abstracts.CatalogService;
import com.turkcell.crm.searchService.entities.concretes.Catalog;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/catalogs")
public class CatalogsController {
    private final CatalogService catalogService;

    @GetMapping("/search")
    public Page<Catalog> searchCatalogs(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Integer> id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);
        return catalogService.searchCatalogs(
                name, id, pageable);
    }
}
