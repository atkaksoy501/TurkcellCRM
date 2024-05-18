package com.turkcell.crm.catalogService.catalogService.business.dtos.requests.catalog;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCatalogRequest {

    @NotNull
    private int id;

    @NotNull
    private String name;

    private List<Integer> productIds;
}
