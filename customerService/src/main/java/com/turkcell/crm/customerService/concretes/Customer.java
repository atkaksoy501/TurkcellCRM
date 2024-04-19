package com.turkcell.crm.customerService.concretes;


import com.turkcell.crm.customerService.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customers")
@SequenceGenerator(
        name = "base_sequence_generator",
        sequenceName = "customer_sequence",
        allocationSize = 1
)
public class Customer extends BaseEntity<Integer> {

    @Column(name = "name")
    private String name;


}
