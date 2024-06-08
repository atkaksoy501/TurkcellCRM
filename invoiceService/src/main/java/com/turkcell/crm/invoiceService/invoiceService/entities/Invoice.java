package com.turkcell.crm.invoiceService.invoiceService.entities;

import com.turkcell.crm.invoiceService.invoiceService.core.entities.BaseEntity;
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
@Table(name = "invoices")
public class Invoice extends BaseEntity<Integer> {

    @Column(name="order_id")
    private int orderId;

    @Column(name="account_id")
    private int accountId;

    @ElementCollection
    @CollectionTable(name = "product_ids")
    @Column(name = "products")
    private List<Integer> productIds;

    @Column(name="total_price")
    private double totalPrice;

}
