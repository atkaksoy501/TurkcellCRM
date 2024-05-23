package com.turkcell.crm.catalogService.catalogService.entities.concretes;

import com.turkcell.crm.catalogService.catalogService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_properties")
public class ProductProperties extends BaseEntity<Integer> {

//    @Column(name="product_id")
//    private int productId;

//    @Column(name="property_id")
//    private int propertyId;

    @Column(name="value")
    private String value;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="property_id", referencedColumnName = "id")
    private Property property;
}
