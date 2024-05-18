package com.turkcell.crm.catalogService.catalogService.business.dtos.requests.product;

import com.turkcell.crm.catalogService.catalogService.entities.concretes.ProductProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProductRequest {

    @NotNull
    private int id;

    private String catalogName;

    private String description;

    private double price;

    private int stockAmount;

    private List<ProductProperties> productProperties;
}
