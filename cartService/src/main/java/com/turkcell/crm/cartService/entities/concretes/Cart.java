package com.turkcell.crm.cartService.entities.concretes;

import com.turkcell.crm.cartService.core.entities.BaseEntity;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
public class Cart extends BaseEntity<String> implements Serializable {
    private String accountId;

    private List<CartItem> items;

    private double totalPrice;

    public Cart() {
        setId(UUID.randomUUID().toString());
        this.items = new ArrayList<>();
    }

}
