package com.turkcell.crm.cartService.business.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddProductToCartRequest {

    @NotNull
    private String accountId;

    @NotNull
    private int productId;

}
