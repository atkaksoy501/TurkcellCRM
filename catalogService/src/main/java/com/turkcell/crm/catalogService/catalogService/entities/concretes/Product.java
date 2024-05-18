package com.turkcell.crm.catalogService.catalogService.entities.concretes;

import com.turkcell.crm.catalogService.catalogService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity<Integer> {

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;

    @Column(name="stock_amount")
    private int stockAmount; //modem gibi cihazlar için

    @OneToMany(mappedBy = "product")
    private List<ProductProperties> productProperties;

    @ManyToOne
    @JoinColumn(name="catalog_id", referencedColumnName = "id")
    private Catalog catalog;
}
