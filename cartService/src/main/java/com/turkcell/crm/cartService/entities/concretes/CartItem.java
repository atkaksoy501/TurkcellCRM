package com.turkcell.crm.cartService.entities.concretes;

import com.turkcell.crm.cartService.core.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CartItem extends BaseEntity<String> {

    private int productId;
    private int quantity;
    private double price;

    public CartItem() {
        setId(UUID.randomUUID().toString());
    }
}
