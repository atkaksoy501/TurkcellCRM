package com.turkcell.crm.cartService.entities.concretes;

import com.turkcell.crm.cartService.core.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem implements Serializable {

    private int productId;
    private int quantity;
    private double price;

}
