package com.turkcell.crm.orderService.entities.concretes;

import com.turkcell.crm.accountService.accountService.entities.concretes.Account;
import com.turkcell.crm.orderService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name="total_amount")
    private double totalAmount;

    @Column(name="address_id")
    private int addressId;

    @ElementCollection
    @CollectionTable(name = "product_ids")
    @Column(name = "products")
    private List<Integer> productIds;

    @Column(name="account_id")
    private int accountId;
}
