package com.turkcell.crm.catalogService.catalogService.entities.concretes;

import com.turkcell.crm.catalogService.catalogService.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "catalogs")
public class Catalog extends BaseEntity<Integer> {

    @Column(name="catalog_name")
    private String catalogName;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;

    @Column(name="stock_amount")
    private int stockAmount; //modem gibi cihazlar için

    @OneToMany(mappedBy = "catalog")
    private List<CatalogProperties> catalogProperties;
}
