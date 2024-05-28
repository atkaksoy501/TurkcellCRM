package com.turkcell.crm.cartService.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddProductToCartRequest {
    private String accountId;
    private int productId;
    private int quantity;
    private double price;
}
