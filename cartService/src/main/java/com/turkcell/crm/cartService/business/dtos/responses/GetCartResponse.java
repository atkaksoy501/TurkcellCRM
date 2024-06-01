package com.turkcell.crm.cartService.business.dtos.responses;

import com.turkcell.crm.cartService.entities.concretes.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCartResponse {
    private String accountId;
    private List<CartItem> items;
    private double totalPrice;
}
