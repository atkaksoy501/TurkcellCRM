package com.turkcell.crm.catalogService.catalogService.business.dtos.responses.product;

import com.turkcell.crm.catalogService.catalogService.entities.concretes.ProductProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedProductResponse {

    private int id;

    private String catalogName;

    private String description;

    private double price;

    private int stockAmount;

    private List<ProductProperties> productProperties;
}
