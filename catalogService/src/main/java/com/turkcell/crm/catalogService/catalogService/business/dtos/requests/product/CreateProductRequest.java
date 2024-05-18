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
public class CreateProductRequest {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private double price;

    @NotNull
    private int stockAmount;

    private List<ProductProperties> productProperties;
}
