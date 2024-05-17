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
@Table(name = "properties")
public class Property extends BaseEntity<Integer> {

    @Column(name="property_name")
    private String propertyName;

    @OneToMany(mappedBy = "property")
    private List<CatalogProperties> catalogProperties;
}
