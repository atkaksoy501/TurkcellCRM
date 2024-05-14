package com.turkcell.crm.customerService.entities.concretes;


import com.turkcell.crm.customerService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(
        name = "base_sequence_generator", //generator name
        sequenceName = "customer_sequence", //this entity's sequence name
        allocationSize = 1 //increment size
)
public class Customer extends BaseEntity<Integer> {
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

}
