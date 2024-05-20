package com.turkcell.crm.orderService.entities.concretes;

import com.turkcell.crm.orderService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItems extends BaseEntity {


    @Column(name="amount")
    private Double amount;

    @OneToOne
    @JoinColumn(name="order_items", referencedColumnName = "id")
    private OrderItems orderItems;


}
