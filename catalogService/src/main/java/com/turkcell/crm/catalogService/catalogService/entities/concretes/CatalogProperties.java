package com.turkcell.crm.catalogService.catalogService.entities.concretes;

import com.turkcell.crm.catalogService.catalogService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "catalog_properties")
public class CatalogProperties extends BaseEntity<Integer> {

    @Column(name="catalog_id")
    private int catalogId;

    @Column(name="property_id")
    private int propertyId;

    @Column(name="value")
    private String value;

    @ManyToOne
    @JoinColumn(name="catalog_id", referencedColumnName = "id")
    private Catalog catalog;

    @ManyToOne
    @JoinColumn(name="property_id", referencedColumnName = "id")
    private Property property;
}
