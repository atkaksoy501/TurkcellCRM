package com.turkcell.crm.invoiceService.invoiceService.entities;

import com.turkcell.crm.invoiceService.invoiceService.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoices")
public class Invoice extends BaseEntity<Integer> {

    @Column(name="order_id")
    private int orderId;
}
