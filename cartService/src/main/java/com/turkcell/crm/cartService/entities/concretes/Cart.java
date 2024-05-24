package com.turkcell.crm.cartService.entities.concretes;

import com.turkcell.crm.cartService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart extends BaseEntity<Integer> {
    @Column(name = "account_id")
    private int accountId;

    @ElementCollection
    @CollectionTable(name = "product_ids")
    @Column(name = "products")
    private Map<Integer, Integer> products; //<productId, quantity>

    @Column(name = "total_price")
    private double totalPrice;
}
