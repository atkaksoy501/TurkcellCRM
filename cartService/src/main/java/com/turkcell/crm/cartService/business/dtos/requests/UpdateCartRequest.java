package com.turkcell.crm.cartService.business.dtos.requests;

import com.turkcell.crm.cartService.entities.concretes.CartItem;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCartRequest {

    @NotNull
    private int id;

    private String accountId;

    private Map<Integer, Integer> products;

    private List<CartItem> items;

    private double totalPrice;
}
