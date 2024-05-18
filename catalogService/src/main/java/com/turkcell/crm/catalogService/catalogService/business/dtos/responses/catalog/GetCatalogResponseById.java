package com.turkcell.crm.catalogService.catalogService.business.dtos.responses.catalog;

import com.turkcell.crm.catalogService.catalogService.entities.concretes.ProductProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCatalogResponseById {

    private String name;

    private List<Integer> productIds;
}
